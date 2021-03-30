package com.leetcode.medium;

import java.util.HashSet;

/**
 * Given a string s, return the number of distinct substrings of s.
 *
 * A substring of a string is obtained by deleting any number of characters (possibly zero) from the front of the string and any number (possibly zero) from the back of the string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aabbaba"
 * Output: 21
 * Explanation: The set of distinct strings is ["a","b","aa","bb","ab","ba","aab","abb","bab","bba","aba","aabb","abba","bbab","baba","aabba","abbab","bbaba","aabbab","abbaba","aabbaba"]
 * Example 2:
 *
 * Input: s = "abcdefg"
 * Output: 28
 */
public class DistinctSubStringsInAString_LC1698 {

    class Trie {
        Trie[] children;
        public Trie() {
            children = new Trie[26];
        }
    }

    public int countDistinct(String s) {
        char[] input = s.toCharArray();
        Trie root = new Trie();
        int subStrings = 0;
        for (int i = 0; i < input.length; i++) {
            Trie cur = root;
            // Try inserting each substring starting at index 'i' in to Trie tree
            // If a prefix string of a substring is not already present in the tree,
            // it must be unique. Update subStrings count and continue processing substring
            for (int j = i; j < input.length; j++) {
                if (cur.children[input[j] - 'a'] == null) {
                    cur.children[input[j] - 'a'] = new Trie();
                    subStrings++;
                }
                cur = cur.children[input[j] - 'a'];
            }
        }
        return subStrings;
    }

    public int countDistinctNaive(String s) {
        HashSet<String> set = new HashSet<>();
        for (int i = 1; i <= s.length(); i++) {
            for (int pos = 0; pos < s.length(); pos++) {
                set.add(s.substring(pos, Math.min(pos + i, s.length())));
            }
        }
        return set.size();
    }
}
