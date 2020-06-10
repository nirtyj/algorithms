package com.leetcode.dp.longestcommonsubstring;

/**
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 */
public class EditDistance_LC72 {

    /**
     * Bottom up DP
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // if word2 is empty, we have to insert all the characters of word1 (same as the i)
        for (int i = 0; i <= word1.length(); i++)
            dp[i][0] = i;
        // if word1 is empty, we have to insert all the characters of word2 (same as the i)
        for (int i = 0; i <= word2.length(); i++)
            dp[0][i] = i;

        // start from 1
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i -1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else {
                    int replace = 1 + dp[i-1][j-1];
                    int delete = 1 + dp[i-1][j];
                    int insert = 1 + dp[i][j-1];
                    dp[i][j] = Math.min(replace, Math.min(delete, insert));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    /**
     * Recursion with memoization
     * @param word1
     * @param word2
     * @return
     */
    public int minDistanceMemo(String word1, String word2) {
        Integer[][] dp = new Integer[word1.length()][word2.length()];
        return recurseHelper(word1, word2, 0, 0, dp);
    }

    public int recurseHelper(String word1, String word2, int i, int j,  Integer[][] dp){

        if (i == word1.length()){
            return word2.length() - j;
        }
        if (j == word2.length()){
            return word1.length() - i;
        }

        if (dp[i][j] != null){
            return dp[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)){
            dp[i][j] = recurseHelper(word1, word2, i+1, j+1, dp);
            return dp[i][j];
        }

        int insert = 1 + recurseHelper(word1, word2, i, j +1, dp);
        int replace = 1 + recurseHelper(word1, word2, i + 1, j +1, dp);
        int delete = 1 + recurseHelper(word1, word2, i + 1, j, dp);
        dp[i][j] = Math.min(insert, Math.min(replace, delete));
        return dp[i][j];
    }

    /**
     * Recursion
     * @param word1
     * @param word2
     * @return
     */
    public int minDistanceNaive(String word1, String word2) {
        return recurseHelper(word1, word2, 0, 0);
    }

    public int recurseHelper(String word1, String word2, int i, int j){
        if (i == word1.length()){
            return word2.length() - j;
        }
        if (j == word2.length()){
            return word1.length() - i;
        }

        if (word1.charAt(i) == word2.charAt(j)){
            return recurseHelper(word1, word2, i+1, j+1);
        }

        int insert = 1 + recurseHelper(word1, word2, i, j +1);
        int replace = 1 + recurseHelper(word1, word2, i + 1, j +1);
        int delete = 1 + recurseHelper(word1, word2, i + 1, j);
        return Math.min(insert, Math.min(replace, delete));
    }

    public static void main(String[] args){
        EditDistance_LC72 ed = new EditDistance_LC72();
        System.out.println(ed.minDistance("horse", "ros"));
    }
}
