package com.leetcode.dp.longestcommonsubstring;

/**
 * Given two strings ‘s1’ and ‘s2’, find the length of the longest substring which is common in both the strings.
 *
 * Example 1:
 *
 * Input: s1 = "abdca"
 *        s2 = "cbda"
 * Output: 2
 * Explanation: The longest common substring is "bd".
 */
public class LongestCommonSubstring {

    /**
     * Get LCS string from bottom up DP O(n*n)
     * @param s1
     * @param s2
     * @return
     */
    public String getLCS(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int max = 0;
        int end = 0;
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];

                    if (dp[i][j] > max){
                        max = dp[i][j];
                        end = i;
                    }
                }
            }
        }
        return s1.substring(end - max, end);
    }

    /**
     * Get length of LCS. O(n*n)
     * @param s1
     * @param s2
     * @return
     */
    public int findLCSLength(String s1, String s2) {
         int[][] dp = new int[s1.length()+1][s2.length()+1];
         int max = 0;
         for(int i=1;i<=s1.length();i++){
             for(int j=1;j<=s2.length();j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    max = Math.max(dp[i][j], max);
                }
             }
         }
     return max;
    }

    /**
     * Get length of LCS. O(n*n)
     * @param s1
     * @param s2
     * @return
     */
    public int findLCSLengthSpaceOptimized(String s1, String s2) {
        int[] prev = new int[s2.length()+1];
        int[] curr = new int[s2.length()+1];
        int max = 0;
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                // reset to for old array val
                curr[j] = 0;
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                    max = Math.max(curr[j], max);
                }
            }
            // swap prev and current
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return max;
    }

    /**
     * Recurse with memoization - O(3^ m*n)
     * @param s1
     * @param s2
     * @return
     */
    public int findLCSLengthMemo(String s1, String s2) {
        String small = s1.length() <= s2.length() ? s1 : s2;
        String big = (small == s1) ? s2: s1;
        return findLCSLengthRecursive(big, small, 0, 0, 0, new Integer[s1.length()][s2.length()][Math.max(small.length(), big.length())]);
    }

    private int findLCSLengthRecursive(String big, String small, int i1, int i2, int count, Integer[][][] memo) {
        if (i1 >= big.length() || i2 >= small.length()){
            return count;
        }
        if (memo[i1][i2][count] != null){
            return memo[i1][i2][count];
        }
        int newcount = count;
        if (big.charAt(i1) == small.charAt(i2)){
            newcount = findLCSLengthRecursive(big, small, i1 + 1, i2 + 1, count + 1, memo);
        }
        int mismatch = findLCSLengthRecursive(big, small, i1, i2 + 1, 0, memo);
        int mismatch2 = findLCSLengthRecursive(big, small, i1 + 1, i2, 0, memo);
        memo[i1][i2][count] = Math.max(newcount, Math.max(mismatch,mismatch2));
        return memo[i1][i2][count];
    }

    public static void main(String[] args) {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        System.out.println(lcs.findLCSLengthSpaceOptimized("abdca", "cbda"));
        System.out.println(lcs.getLCS("abdca", "cbda"));

        System.out.println(lcs.findLCSLengthSpaceOptimized("passport", "ppsspt"));
        System.out.println(lcs.getLCS("passport", "ppsspt"));
    }
}
