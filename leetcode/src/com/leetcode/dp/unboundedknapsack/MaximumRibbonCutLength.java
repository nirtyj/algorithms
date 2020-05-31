package com.leetcode.dp.unboundedknapsack;

/**
 * We are given a ribbon of length ‘n’ and a set of possible ribbon lengths.
 * Now we need to cut the ribbon into the maximum number of pieces that
 * comply with the above-mentioned possible lengths. Write a method that will return the count of pieces.
 * <p>
 * Example 1:
 * <p>
 * n: 5
 * Ribbon Lengths: {2,3,5}
 * Output: 2
 * Explanation: Ribbon pieces will be {2,3}.
 */
public class MaximumRibbonCutLength {

    /**
     * 1D bottom up 
     * @param denominations
     * @param total
     * @return
     */
    public int countRibbonPieces(int[] denominations, int total)
    {
        Integer[] dp = new Integer[total + 1];
        dp[0] = 0;
        for (int coin : denominations) {
            for (int c = 1; c <= total; c++) {
                if (c >= coin && dp[c - coin] != null) {
                    dp[c] = Math.max(dp[c] == null ? Integer.MIN_VALUE : dp[c], (dp[c - coin] + 1));
                }
            }
        }
        return dp[total] == null ? -1 : dp[total];
    }

    /**
     * Recursive with memoization
     * @param ribbonLengths
     * @param total
     * @return
     */
    public int countRibbonPiecesMemoization(int[] ribbonLengths, int total) {
        Integer[][] dp = new Integer[ribbonLengths.length][total + 1];
        int val = countRibbonRecursive(dp, ribbonLengths, total, 0);
        return (val == Integer.MIN_VALUE ? -1 : val);
    }

    private Integer countRibbonRecursive(Integer[][] dp, int[] ribbonLength, int total, int index) {
        if (index >= ribbonLength.length) {
            return Integer.MIN_VALUE;
        }
        if (total == 0) {
            return 0;
        }

        if (dp[index][total] == null) {
            int without = countRibbonRecursive(dp, ribbonLength, total, index + 1);
            int with = Integer.MIN_VALUE;
            if (ribbonLength[index] <= total) {
                with = countRibbonRecursive(dp, ribbonLength, total - ribbonLength[index], index);
                if (with != Integer.MIN_VALUE) {
                    with++;
                }
            }
            dp[index][total] = Math.max(with, without);
        }
        return dp[index][total];
    }

    public static void main(String[] args) {
        MaximumRibbonCutLength cr = new MaximumRibbonCutLength();
        int[] ribbonLengths = {2, 3, 5};
        System.out.println(cr.countRibbonPieces(ribbonLengths, 5));
        ribbonLengths = new int[]{2, 3};
        System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
        ribbonLengths = new int[]{3, 5, 7};
        System.out.println(cr.countRibbonPieces(ribbonLengths, 13));
        ribbonLengths = new int[]{3, 5};
        System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
    }
}
