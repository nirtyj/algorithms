package com.leetcode.dp.longestcommonsubstring;

/**
 * Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.
 * If multiple answers exist, you may return any of them.
 *
 * (A string S is a subsequence of string T if deleting some number of characters from T (possibly 0, and the characters are chosen anywhere from T) results in the string S.)
 *
 *
 *
 * Example 1:
 *
 * Input: str1 = "abac", str2 = "cab"
 * Output: "cabac"
 * Explanation:
 * str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
 * str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
 * The answer provided is the shortest such string that satisfies these properties.
 */
public class ShortestCommonSuperSequence_LC1092 {

    /**
     * Just the length for SCS based on LCS
     * @param s1
     * @param s2
     * @return
     */
    public int findSCSLength(String s1, String s2) {
        int c1 = findLCSLength(s1, s2);
        return ((s1.length() + s2.length()) - c1);
    }

    private int findLCSLength(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
