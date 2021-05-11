package com.leetcode.graph.unionfind;

import java.util.Arrays;

/**
 * Given an array equations of strings that represent relationships between variables, each string equations[i] has length 4 and takes one of two different forms: "a==b" or "a!=b".  Here, a and b are lowercase letters (not necessarily different) that represent one-letter variable names.
 *
 * Return true if and only if it is possible to assign integers to variable names so as to satisfy all the given equations.
 *
 *
 *
 * Example 1:
 *
 * Input: ["a==b","b!=a"]
 * Output: false
 * Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.  There is no way to assign the variables to satisfy both equations.
 * Example 2:
 *
 * Input: ["b==a","a==b"]
 * Output: true
 * Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
 * Example 3:
 *
 * Input: ["a==b","b==c","a==c"]
 * Output: true
 * Example 4:
 *
 * Input: ["a==b","b!=c","c==a"]
 * Output: false
 * Example 5:
 *
 * Input: ["c==c","b==d","x!=z"]
 * Output: true
 */
public class SatisfiabilityOfEqualityEquations_LC990 {
    int[] parent;

    int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return find(parent[x]);
        }
    }

    /**
     * Two pass for grouping equals. Then last time to check if anything breaks with != operator.
     * start with -1, init with same root
     * @param equations
     * @return
     */
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        Arrays.fill(parent, -1);
        for (String eq : equations) {
            int node1 = eq.charAt(0) - 'a';
            int node2 = eq.charAt(3) - 'a';
            if (parent[node1] == -1) {
                parent[node1] = node1;
            }
            if (parent[node2] == -1) {
                parent[node2] = node2;
            }
            int group1 = find(node1);
            int group2 = find(node2);
            if (eq.charAt(1) == '=') {
                parent[group2] = group1;
            }
        }

        for (String eq : equations) {
            int node1 = eq.charAt(0) - 'a';
            int node2 = eq.charAt(3) - 'a';
            int group1 = find(node1);
            int group2 = find(node2);
            if (eq.charAt(1) == '!' && group1 == group2) {
                return false;
            }
        }
        return true;
    }

    /**
     * Init by default
     * @param equations
     * @return
     */
    public boolean equationsPossibleAlternative(String[] equations) {
        parent = new int[26];
        for (int i = 0; i < 26; ++i)
            parent[i] = i;
        for (String eq : equations) {
            int node1 = eq.charAt(0) - 'a';
            int node2 = eq.charAt(3) - 'a';
            int group1 = find(node1);
            int group2 = find(node2);
            if (eq.charAt(1) == '=') {
                parent[group2] = group1;
            }
        }

        for (String eq : equations) {
            int node1 = eq.charAt(0) - 'a';
            int node2 = eq.charAt(3) - 'a';
            int group1 = find(node1);
            int group2 = find(node2);
            if (eq.charAt(1) == '!' && group1 == group2) {
                return false;
            }
        }
        return true;
    }

}
