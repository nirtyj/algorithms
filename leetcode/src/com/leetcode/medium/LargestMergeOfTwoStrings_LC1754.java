package com.leetcode.medium;

/**
 * You are given two strings word1 and word2. You want to construct a string merge in the following way: while either word1 or word2 are non-empty, choose one of the following options:
 *
 * If word1 is non-empty, append the first character in word1 to merge and delete it from word1.
 * For example, if word1 = "abc" and merge = "dv", then after choosing this operation, word1 = "bc" and merge = "dva".
 * If word2 is non-empty, append the first character in word2 to merge and delete it from word2.
 * For example, if word2 = "abc" and merge = "", then after choosing this operation, word2 = "bc" and merge = "a".
 * Return the lexicographically largest merge you can construct.
 *
 * A string a is lexicographically larger than a string b (of the same length) if in the first position where a and b differ, a has a character strictly larger than the corresponding character in b. For example, "abcd" is lexicographically larger than "abcc" because the first position they differ is at the fourth character, and d is greater than c.
 *
 *
 *
 * Example 1:
 *
 * Input: word1 = "cabaa", word2 = "bcaaa"
 * Output: "cbcabaaaaa"
 * Explanation: One way to get the lexicographically largest merge is:
 * - Take from word1: merge = "c", word1 = "abaa", word2 = "bcaaa"
 * - Take from word2: merge = "cb", word1 = "abaa", word2 = "caaa"
 * - Take from word2: merge = "cbc", word1 = "abaa", word2 = "aaa"
 * - Take from word1: merge = "cbca", word1 = "baa", word2 = "aaa"
 * - Take from word1: merge = "cbcab", word1 = "aa", word2 = "aaa"
 * - Append the remaining 5 a's from word1 and word2 at the end of merge.
 * Example 2:
 *
 * Input: word1 = "abcabc", word2 = "abdcaba"
 * Output: "abdcabcabcaba"
 */
public class LargestMergeOfTwoStrings_LC1754 {

    // greedy recursive
    public String largestMergeGreedy(String s1, String s2) {
        if (s1.length() == 0  || s2.length() == 0)
            return s1 + s2;
        if (s1.compareTo(s2) > 0)
            return s1.charAt(0) + largestMergeGreedy(s1.substring(1), s2);
        return s2.charAt(0) + largestMergeGreedy(s1, s2.substring(1));
    }

    // Simple look ahead to add.
    public String largestMergeSimple(String word1, String word2) {
        StringBuffer result = new StringBuffer();
        int i=0, j=0;
        while(i< word1.length() && j< word2.length()) {
            // compareTo does the look ahead with substring (beginindex)
            if (word1.substring(i).compareTo(word2.substring(j)) > 0)
                result.append(word1.charAt(i++));
            else
                result.append(word2.charAt(j++));
        }
        result.append(word1.substring(i));
        result.append(word2.substring(j));
        return result.toString();
    }

    // look ahead to add.
    public String largestMerge(String word1, String word2) {
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while(i< word1.length() && j < word2.length()){
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(j);
            if (c1 > c2){
                sb.append(c1);
                i++;
            } else if (c2 > c1) {
                sb.append(c2);
                j++;
            } else {
                boolean isWord1 = shouldAddWord1(word1, i, word2, j);
                if (isWord1) {
                    sb.append(c1);
                    i++;
                } else {
                    sb.append(c2);
                    j++;
                }
            }
        }
        sb.append(word1.substring(i));
        sb.append(word2.substring(j));
        return sb.toString();
    }

    boolean shouldAddWord1(String word1, int i, String word2, int j){
        boolean isWord1 = true;
        while(i< word1.length() && j < word2.length()){
            if (word2.charAt(j) > word1.charAt(i)) {
                return false;
            } else if (word2.charAt(j) < word1.charAt(i)) {
                return true;
            } else {
                i++;
                j++;
            }
        }
        if ( i == word1.length()){
            return false;
        }
        return isWord1;
    }
}
