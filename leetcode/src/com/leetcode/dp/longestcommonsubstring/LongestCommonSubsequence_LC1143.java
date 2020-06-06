package com.leetcode.dp.longestcommonsubstring;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 *
 * A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
 *
 * If there is no common subsequence, return 0.
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 */
public class LongestCommonSubsequence_LC1143 {

    /**
     * Bottom up DP 1D array
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int[] dp = new int[text2.length() + 1];
        for(int i =1;i<=text1.length();i++){
            int prev = 0; // represents i-1,j-1
            for (int j = 1;j<=text2.length();j++){
                int temp = dp[j]; // copy current val to be used for i-1,j-1 before getting overridden by current loop––
                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[j] = 1 + prev;
                } else {
                    dp[j] = Math.max(dp[j-1], dp[j]);
                }
                prev = temp;
            }

        }
        return dp[text2.length()];
    }

    /**
     * Bottom up DP 2D array
     */
    public int longestCommonSubsequence2DBottomup(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for(int i =1;i<=text1.length();i++){
            for (int j = 1;j<=text2.length();j++){
                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i -1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
    /**
     * With memoization
     */
    public int longestCommonSubsequenceMemo(String text1, String text2) {
        return recurseHelper(text1, text2, 0, 0, new Integer[text1.length()][text2.length()]);
    }

    public int recurseHelper(String s1, String s2, int i1, int i2, Integer[][] memo){
        if (i1 >=s1.length() || i2 >= s2.length()){
            return 0;
        }

        if(memo[i1][i2] != null){
            return memo[i1][i2];
        }

        int newcount = 0;
        if (s1.charAt(i1) == s2.charAt(i2)){
            newcount = 1 + recurseHelper(s1, s2, i1+ 1, i2+1, memo);
        } else {
            if (i2+1 < s2.length()){
                memo[i1][i2+1] = recurseHelper(s1, s2, i1, i2 + 1, memo);
                newcount  = Math.max(newcount, memo[i1][i2+1]);
            }
            if (i1 +1 < s1.length()){
                memo[i1 + 1][i2] = recurseHelper(s1, s2, i1 + 1, i2, memo);
                newcount  = Math.max(newcount , memo[i1 + 1][i2]);
            }
        }
        memo[i1][i2] = newcount;
        return memo[i1][i2];
    }

    private String getKey(int i1, int i2){
        return i1+"|"+i2;
    }

    /**
     * basic recursion
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequenceNaiveRecursion(String text1, String text2) {
        return recurseHelper(text1, text2, 0, 0);
    }

    public int recurseHelper(String s1, String s2, int i1, int i2){
        if (i1 >=s1.length() || i2 >= s2.length()){
            return 0;
        }

        int newcount = 0;
        if (s1.charAt(i1) == s2.charAt(i2)){
            newcount =  1 + recurseHelper(s1, s2, i1+ 1, i2+1);
        } else {
            newcount = Math.max(newcount, recurseHelper(s1, s2, i1, i2 + 1));
            newcount = Math.max(newcount, recurseHelper(s1, s2, i1 + 1, i2));
        }
        return newcount;
    }
}
