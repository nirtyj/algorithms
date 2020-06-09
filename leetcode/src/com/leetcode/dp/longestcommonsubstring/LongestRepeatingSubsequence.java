package com.leetcode.dp.longestcommonsubstring;

import com.leetcode.common.PrintUtils;

/**
 * Problem Statement #
 * Given a sequence, find the length of its longest repeating subsequence (LRS). A repeating subsequence will be the one that appears at least twice in the original sequence and is not overlapping (i.e. none of the corresponding characters in the repeating subsequences have the same index).
 *
 * Example 1:
 *
 * Input: “t o m o r r o w”
 * Output: 2
 * Explanation: The longest repeating subsequence is “or” {tomorrow}.
 */
public class LongestRepeatingSubsequence {

    public int findLRSLengthBottomUp(String str) {
        int[][] dp = new int[str.length()+1][str.length()+1];
        for(int i=1;i<=str.length();i++){
            for(int j=1;j<=str.length();j++){
                if ( i!=j && str.charAt(i-1) == str.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        PrintUtils.print(dp);
        return dp[str.length()][str.length()];
    }

    public int findLRSLengthMemo(String str) {
        Integer[][] dp = new Integer[str.length()][str.length()];
        int result =  findLRSLengthRecursiveMemo(str, 0, 0, dp);
        PrintUtils.print(dp);
        return result;
    }

    private int findLRSLengthRecursiveMemo(String str, int i1, int i2, Integer[][] dp) {
        if (i1 >=str.length() || i2 >= str.length()){
            return 0;
        }
        if (dp[i1][i2] != null){
            return dp[i1][i2];
        }

        if (str.charAt(i1) == str.charAt(i2) && i1 != i2){
            dp[i1][i2] = 1 + findLRSLengthRecursiveMemo(str, i1 + 1, i2 + 1, dp);
            return dp[i1][i2];
        }
        int other1 = findLRSLengthRecursiveMemo(str, i1 + 1, i2, dp);
        int other2 = findLRSLengthRecursiveMemo(str, i1, i2 + 1, dp);
        dp[i1][i2] = Math.max(other1, other2);
        return dp[i1][i2];
    }

    public int findLRSLengthNaive(String str) {
        return findLRSLengthRecursive(str, 0, 0);
    }

    private int findLRSLengthRecursive(String str, int i1, int i2) {
        if (i1 >=str.length() || i2 >= str.length()){
            return 0;
        }

        if (str.charAt(i1) == str.charAt(i2) && i1 != i2){
            return 1 + findLRSLengthRecursive(str, i1 + 1, i2 + 1);
        }
        int other1 = findLRSLengthRecursive(str, i1 + 1, i2);
        int other2 = findLRSLengthRecursive(str, i1, i2 + 1);

        return Math.max(other1, other2);
    }

    public static void main(String[] args) {
        LongestRepeatingSubsequence lrs = new LongestRepeatingSubsequence();
        System.out.println(lrs.findLRSLengthMemo("tomorrow"));
        System.out.println(lrs.findLRSLengthBottomUp("tomorrow"));
        System.out.println(lrs.findLRSLengthNaive("fmff"));
    }
}
