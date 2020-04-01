package com.leetcode.easy;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {

    /**
     * Leetcode verified
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String lcp = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            String s = strs[i];
            for (; j < s.length() && j < lcp.length(); j++) {
                if (s.charAt(j) != lcp.charAt(j)) {
                    if (j == 0) {
                        lcp = "";
                    } else {
                        lcp = lcp.substring(0, j);
                    }
                    break;
                }
            }
            if (j < lcp.length()) {
                lcp = lcp.substring(0, j);
            }
        }
        return lcp;
    }

    public static String longestCommonPrefix2Iterations(String[] strs) {

        String smallest = null;
        int minSize = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < minSize) {
                minSize = str.length();
                smallest = str;
            }
        }

        boolean mismatch = false;
        int i;
        for (i = 0; i < smallest.length(); i++) {
            for (String str : strs) {
                if (str.charAt(i) != smallest.charAt(i)) {
                    mismatch = true;
                    break;
                }
            }

            if (mismatch)
                break;
        }

        return smallest.substring(0, i);
    }
}
