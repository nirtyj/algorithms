package com.leetcode.dp.longestcommonsubstring;

/**
 * Problem Statement #
 * Given strings s1 and s2, we need to transform s1 into s2 by deleting and inserting characters. Write a function to calculate the count of the minimum number of deletion and insertion operations.
 *
 * Example 1:
 *
 * Input: s1 = "abc"
 *        s2 = "fbc"
 * Output: 1 deletion and 1 insertion.
 * Explanation: We need to delete {'a'} and insert {'f'} to s1 to transform it into s2.
 */
public class MinimumDeletionInsertionToFormString {

    /**
     * find the common subsequence. then delete from s1 (s1 - lcs), then add needed items from s2 (s2-lcs)
     * @param s1
     * @param s2
     */
    public void findMDI(String s1, String s2) {
        int c1 = findLCSLength(s1, s2);
        System.out.println("Minimum deletions needed: " + (s1.length() - c1));
        System.out.println("Minimum insertions needed: " + (s2.length() - c1));
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


    public static void main(String[] args) {
        MinimumDeletionInsertionToFormString mdi = new MinimumDeletionInsertionToFormString();
        mdi.findMDI("abc", "fbc");
        mdi.findMDI("abdca", "cbda");
        mdi.findMDI("passport", "ppsspt");
    }
}
