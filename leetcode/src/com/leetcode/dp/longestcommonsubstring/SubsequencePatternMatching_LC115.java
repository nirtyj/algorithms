package com.leetcode.dp.longestcommonsubstring;

/**
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * It's guaranteed the answer fits on a 32-bit signed integer.
 *
 * Example 1:
 *
 * Input: S = "rabbbit", T = "rabbit"
 * Output: 3
 * Explanation:
 * As shown below, there are 3 ways you can generate "rabbit" from S.
 * (The caret symbol ^ means the chosen letters)
 *
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 */
public class SubsequencePatternMatching_LC115 {

    /**
     * Recursion with memoization
     * @param str
     * @param pat
     * @return
     */
    public int findSPMCount(String str, String pat) {
        Integer[][] dp = new Integer[str.length()][pat.length()];
        return findSPMCountRecursive(dp, str, pat, 0, 0);
    }

    private int findSPMCountRecursive(Integer[][] dp, String str, String pat, int strIndex, int patIndex) {
        // if we have reached the end of the pattern
        if (patIndex == pat.length())
            return 1;

        // if we have reached the end of the string but pattern has still some characters left
        if (strIndex == str.length())
            return 0;

        if (dp[strIndex][patIndex] != null) {
            return dp[strIndex][patIndex];
        }
        // if its equal, count doesnt increase
        // by +1 (thats for longest). however, the count increases if your without characters is added
        int c1 = 0;
        if (str.charAt(strIndex) == pat.charAt(patIndex)) {
            c1 = findSPMCountRecursive(dp, str, pat, strIndex + 1, patIndex + 1);
        }
        int c2 = findSPMCountRecursive(dp, str, pat, strIndex + 1, patIndex);
        dp[strIndex][patIndex] = c1 + c2;
        return dp[strIndex][patIndex];
    }

    public int numDistinct(String str, String pat) {
        // every empty pattern has one match
        if (pat.length() == 0)
            return 1;

        if (str.length() == 0 || pat.length() > str.length())
            return 0;

        int[][] dp = new int[str.length() + 1][pat.length() + 1];
        for (int i = 0; i <= str.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= str.length(); i++) {
            for (int j = 1; j <= pat.length(); j++) {
                if (str.charAt(i - 1) == pat.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                dp[i][j] = dp[i][j] + dp[i - 1][j];
            }
        }
        return dp[str.length()][pat.length()];
    }

    public static void main(String[] args) {
        SubsequencePatternMatching_LC115 spm = new SubsequencePatternMatching_LC115();
        System.out.println(spm.numDistinct("baxmx", "ax"));
        System.out.println(spm.numDistinct("tomorrow", "tor"));
        System.out.println(spm.numDistinct("rabbbit", "rabbit"));
    }
}
