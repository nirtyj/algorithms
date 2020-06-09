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
     * O(n*n). find lcs and then go traverse to find out the string.
     * @param str1
     * @param str2
     * @return
     */
    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = LongestCommonSubsequence_LC1143.longestCommonSubsequenceReturnDp(str1, str2);
        StringBuilder sb = new StringBuilder();
        int i = str1.length();
        int j = str2.length();
        while(i>0 && j>0){
            if (dp[i][j] == dp[i-1][j] + 1 && dp[i][j] == dp[i][j -1] + 1 ){
                sb.append(str1.charAt(i -1));
                i--;
                j--;
            }
            else if (dp[i][j] == dp[i-1][j]) {
                sb.append(str1.charAt(i-1));
                i--;
            } else {
                sb.append(str2.charAt(j-1));
                j--;
            }
        }
        while (i>0){
            sb.append(str1.charAt(i-1));
            i--;
        }
        while (j>0){
            sb.append(str2.charAt(j-1));
            j--;
        }
        return sb.reverse().toString();
    }

    /**
     * Just the length for SCS based on LCS
     * @param s1
     * @param s2
     * @return
     */
    public int findSCSLength(String s1, String s2) {
        int c1 = LongestCommonSubsequence_LC1143.longestCommonSubsequence(s1, s2);
        return ((s1.length() + s2.length()) - c1);
    }
}
