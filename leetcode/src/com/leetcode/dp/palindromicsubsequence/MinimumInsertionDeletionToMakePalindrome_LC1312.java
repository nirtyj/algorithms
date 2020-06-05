package com.leetcode.dp.palindromicsubsequence;

/**
 * iven a string s. In one step you can insert any character at any index of the string.
 *
 * Return the minimum number of steps to make s palindrome.
 *
 * A Palindrome String is one that reads the same backward as well as forward.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "zzazz"
 * Output: 0
 * Explanation: The string "zzazz" is already palindrome we don't need any insertions.
 * Example 2:
 *
 * Input: s = "mbadm"
 * Output: 2
 * Explanation: String can be "mbdadbm" or "mdbabdm".
 * Example 3:
 *
 * Input: s = "leetcode"
 * Output: 5
 * Explanation: Inserting 5 characters the string becomes "leetcodocteel".
 * Example 4:
 *
 * Input: s = "g"
 * Output: 0
 * Example 5:
 *
 * Input: s = "no"
 * Output: 1
 */
public class MinimumInsertionDeletionToMakePalindrome_LC1312 {

    /**
     *
     * @param word
     * @return
     */
    public int minInsertions(String word) {
        return word.length() - findMaxSubsequence(word);
    }

    /**
     * Find max subsequence and subtract from the total length
     * @param word
     * @return
     */
    private int findMinimumDeletions(String word) {
        return word.length() - findMaxSubsequence(word);
    }

    public int findMaxSubsequence(String st) {
        int[][] dp = new int[st.length()][st.length()];
        for(int i=0;i<st.length();i++){
            dp[i][i] = 1;
        }
        for (int i =  st.length() - 2; i >= 0; i--){
            for(int j = i + 1;j<st.length();j++){
                if (st.charAt(i) == st.charAt(j)){
                    dp[i][j] = 2 + dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1] , dp[i+1][j]);
                }
            }
        }
        return dp[0][st.length()-1];
    }

    public static void main(String[] args) {
        MinimumInsertionDeletionToMakePalindrome_LC1312 mdsp = new MinimumInsertionDeletionToMakePalindrome_LC1312();
        System.out.println(mdsp.findMinimumDeletions("abdbca"));
        System.out.println(mdsp.findMinimumDeletions("cddpd"));
        System.out.println(mdsp.findMinimumDeletions("pqr"));
    }


}
