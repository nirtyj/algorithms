package com.leetcode.graph.unionfind;

import com.leetcode.common.DisjointSetUnion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.
 * <p>
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that is common to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.
 * <p>
 * After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 * <p>
 * Example 1:
 * Input:
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * Explanation:
 * The first and third John's are the same person as they have the common email "johnsmith@mail.com".
 * The second John and Mary are different people as none of their email addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 * Note:
 * <p>
 * The length of accounts will be in the range [1, 1000].
 * The length of accounts[i] will be in the range [1, 10].
 * The length of accounts[i][j] will be in the range [1, 30]
 */
public class AccountsMerge_LC721 {

    /**
     * Leetcode accepted - Disjoint sets
     *
     * @param accounts
     * @return
     */
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts.size() == 0) {
            return Collections.emptyList();
        }
        DisjointSetUnion u = new DisjointSetUnion(10000);
        HashMap<String, String> emailToName = new HashMap<>();
        HashMap<String, Integer> emailToID = new HashMap<>();
        int id = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                // dont create a new id, if its been seen already
                if (!emailToID.containsKey(email)) {
                    emailToID.put(email, id++);
                }
                emailToName.put(email, name);
                // for each email in the account, union to the first email. so, all the emails in an account are mapped to one id
                // if emails are from different account, and its seen earlier, use that id to union to this account.
                u.union(emailToID.get(account.get(1)), emailToID.get(email));
            }
        }

        // now map all the emails to the single account ID
        Map<Integer, List<String>> idToEmails = new HashMap<>();
        for (Map.Entry<String, String> entry : emailToName.entrySet()) {
            Integer idd = u.find(emailToID.get(entry.getKey()));
            List<String> emails = idToEmails.getOrDefault(idd, new ArrayList<>());
            emails.add(entry.getKey());
            idToEmails.put(idd, emails);
        }

        // calculate result
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> e : idToEmails.entrySet()) {
            List<String> emails = e.getValue();
            Collections.sort(emails);
            emails.add(0, emailToName.get(emails.get(0)));
            result.add(emails);
        }
        return result;
    }

    /**
     * Leetcode accepted - Graph + DFS
     *
     * @param accounts
     * @return
     */
    public static List<List<String>> accountsMergeGrpah(List<List<String>> accounts) {
        HashMap<String, String> emailToName = new HashMap<>();
        HashMap<String, List<Account>> emailToAccounts = new HashMap<>();

        for (List<String> acct : accounts) {
            Account a = new Account(acct);
            for (String email : a.emails) {
                emailToName.put(email, a.name);
                List<Account> accountObjsForEmail = emailToAccounts.getOrDefault(email, new ArrayList<>());
                accountObjsForEmail.add(a);
                emailToAccounts.put(email, accountObjsForEmail);
            }
        }

        List<List<String>> result = new ArrayList<>();
        HashSet<String> emailsSeen = new HashSet<>();
        for (Map.Entry<String, List<Account>> entry : emailToAccounts.entrySet()) {
            HashSet<String> emailsAssociated = new HashSet<>();
            dfs(entry.getKey(), emailToAccounts, emailsAssociated, emailsSeen);
            if (emailsAssociated.isEmpty())
                continue;
            ArrayList<String> resultEntry = new ArrayList<String>(emailsAssociated);
            Collections.sort(resultEntry);
            resultEntry.add(0, emailToName.get(entry.getKey()));
            result.add(resultEntry);
        }
        return result;
    }

    private static void dfs(String email, HashMap<String, List<Account>> emailToAccounts,
                            HashSet<String> emailsAssociated, HashSet<String> seen) {
        if (seen.contains(email))
            return;
        else {
            seen.add(email);
            emailsAssociated.add(email);
            for (Account a : emailToAccounts.get(email)) {
                for (String e : a.emails) {
                    dfs(e, emailToAccounts, emailsAssociated, seen);
                }
            }
        }
    }

    /**
     * Time limit exceeded - Naive HashMap
     *
     * @param accounts
     * @return
     */
    public static List<List<String>> accountsMergeTle(List<List<String>> accounts) {
        HashMap<String, Account> map = new HashMap<>();
        for (List<String> acct : accounts) {
            Account a = new Account(acct);
            List<Account> existingAccts = new ArrayList<>();
            HashMap<String, Account> tempMap = new HashMap<>();
            for (String email : a.emails) {
                tempMap.put(email, a);
                if (map.containsKey(email)) {
                    existingAccts.add(map.get(email));
                }
            }

            if (existingAccts.size() == 0) {
                map.putAll(tempMap);
            } else {
                existingAccts.add(a);
                Account newMergedAcct = new Account();
                for (Account existingacct : existingAccts) {
                    newMergedAcct.name = existingacct.name;
                    for (String email : existingacct.emails) {
                        map.put(email, newMergedAcct);
                        newMergedAcct.emails.add(email);
                    }
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        HashSet<Account> uniqueObjs = new HashSet<>(map.values());
        for (Account a : uniqueObjs)
            result.add(a.getStrings());

        return result;
    }

     static class Account {
        String name;
        Set<String> emails = new HashSet<>();

        public Account(List<String> strings) {
            this.name = strings.get(0);
            this.emails.addAll(strings);
            this.emails.remove(this.name);
        }

         public Account() {}

         public List<String> getStrings() {
            List<String> vals = new ArrayList<>();
            vals.add(this.name);
            vals.addAll(emails);
            Collections.sort(vals);
            return vals;
        }
    }
}
