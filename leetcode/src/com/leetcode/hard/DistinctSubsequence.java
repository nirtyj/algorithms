package com.leetcode.hard;

/**
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 * <p>
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * <p>
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * <p>
 * Return 3.
 */
public class DistinctSubsequence {

    /**
     * @param S
     * @param T
     * @return
     */
    public static int numDistincts(String S, String T) {
        int[][] table = new int[S.length() + 1][T.length() + 1];

        for (int i = 0; i < S.length(); i++)
            table[i][0] = 1;

        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    table[i][j] += table[i - 1][j] + table[i - 1][j - 1];
                } else {
                    table[i][j] += table[i - 1][j];
                }
            }
        }

        return table[S.length()][T.length()];
    }

}
