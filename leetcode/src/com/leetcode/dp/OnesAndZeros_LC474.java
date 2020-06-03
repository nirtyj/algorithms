package com.leetcode.dp;

/**
 * Given an array, strs, with strings consisting of only 0s and 1s. Also two integers m and n.
 *
 * Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s.
 * Each 0 and 1 can be used at most once.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
 * Output: 4
 * Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are "10","0001","1","0".
 * Example 2:
 *
 * Input: strs = ["10","0","1"], m = 1, n = 1
 * Output: 2
 * Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] consists only of digits '0' and '1'.
 * 1 <= m, n <= 100
 */
public class OnesAndZeros_LC474 {

    /** Recursion with memoization
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int[][][] memo = new int[strs.length][m + 1][n + 1];
        return calculate(strs, 0, m, n, memo);
    }

    private int calculate(String[] strs, int index, int remM, int remN, int[][][] memo) {
        if (index >= strs.length) {
            return 0;
        }
        if (memo[index][remM][remN] != 0)
            return memo[index][remM][remN];

        String str = strs[index];
        int ones = 0;
        int zeros = 0;
        for (Character c: str.toCharArray()) {
            if (c=='1') {
                ones++;
            } else {
                zeros++;
            }
        }
        int maxwithout = calculate(strs, index + 1, remM, remN, memo);
        int max2with = 0;
        if (remM - zeros >=0 && remN - ones >= 0) {
            max2with = calculate(strs, index + 1, remM - zeros, remN - ones, memo) + 1;
        }
        memo[index][remM][remN] = Math.max(maxwithout, max2with);
        return Math.max(maxwithout, max2with);
    }
}
