package com.leetcode.dp.unboundedknapsack;

/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 * <p>
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 * <p>
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {

    /**
     * Leetcode verified - 1D Dynamic programming
     *
     * @param denominations
     * @param total
     * @return
     */
    public int coinChange(int[] denominations, int total) {
        Integer[] dp = new Integer[total + 1];
        dp[0] = 0;
        for (int coin : denominations) {
            for (int c = 1; c <= total; c++) {
                if (c >= coin && dp[c - coin] != null) {
                    dp[c] = Math.min(dp[c] == null ? Integer.MAX_VALUE : dp[c], (dp[c - coin] + 1));
                }
            }
        }
        return dp[total] == null ? -1 : dp[total];
    }

    /**
     * Coin change 2D dynamic programming.
     */
    public int coinChange2D(int[] denominations, int total) {
        int n = denominations.length;
        Integer[][] dp = new Integer[n][total + 1];

        // populate the total=0 columns, as we don't need any coin to make zero total
        for(int i=0; i < n; i++)
            dp[i][0] = 0;

        for(int i=0; i < n; i++) {
            for(int c=1; c <= total; c++) {
                // without the coin
                if(i > 0) {
                    dp[i][c] = dp[i-1][c];
                }
                // if its possible to include the coin in current capacity
                // and the remaining is possible (not null)
                if(c >= denominations[i] && dp[i][c-denominations[i]] != null) {
                    dp[i][c] = dp[i][c] == null ? Integer.MAX_VALUE : dp[i][c];
                    dp[i][c] = Math.min(dp[i][c], dp[i][c-denominations[i]]+1);
                }
            }
        }

        // total combinations will be at the bottom-right corner.
        return (dp[n-1][total] == null ? -1 : dp[n-1][total]);
    }

    /**
     * Recursive + memoization
     * @param denominations
     * @param total
     * @return
     */
    public int coinChangeMemoization(int[] denominations, int total) {
        Integer[][] dp = new Integer[denominations.length][total + 1];
        int result = this.countChangeRecursive(dp, denominations, total, 0);
        return (result == Integer.MAX_VALUE ? -1 : result);
    }

    private int countChangeRecursive(Integer[][] dp, int[] denominations, int total, int currentIndex) {
        // base check
        if (total == 0)
            return 0;

        if(denominations.length == 0 || currentIndex >= denominations.length)
            return Integer.MAX_VALUE;

        // check if we have not already processed a similar sub-problem
        if(dp[currentIndex][total] == null) {
            // recursive call after selecting the coin at the currentIndex
            // if the coin at currentIndex exceeds the total, we shouldn't process this
            int with = Integer.MAX_VALUE;
            if(denominations[currentIndex] <= total ) {
                int res = countChangeRecursive(dp, denominations, total - denominations[currentIndex], currentIndex);
                if(res != Integer.MAX_VALUE){
                    with = res + 1;
                }
            }

            // recursive call after excluding the coin at the currentIndex
            int without = countChangeRecursive(dp, denominations, total, currentIndex + 1);
            dp[currentIndex][total] = Math.min(with, without);
        }
        return dp[currentIndex][total];
    }
}
