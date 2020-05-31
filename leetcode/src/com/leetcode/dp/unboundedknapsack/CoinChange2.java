package com.leetcode.dp.unboundedknapsack;

/**
 * You are given coins of different denominations and a total amount of money.
 * Write a function to compute the number of combinations that make up that amount.
 * You may assume that you have infinite number of each kind of coin.
 *
 *
 *
 * Example 1:
 *
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * Example 2:
 *
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * Example 3:
 *
 * Input: amount = 10, coins = [10]
 * Output: 1
 */
public class CoinChange2 {

    /**
     * 1D bottom up DP
     */
    public int change(int amount, int[] coins) {
        if (amount == 0){
            return 1;
        }
        if (coins == null || coins.length == 0) {
            return 0;
        }
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin: coins){
            for(int c=1;c<=amount;c++){
                int without = dp[c];
                int with = 0;
                if (coin <= c) {
                    with = dp[c-coin];
                }
                dp[c] =  with + without;
            }
        }
        return dp[amount];
    }

    /**
     * 2D bottom up DP
     * @param total
     * @param coins
     * @return
     */
    public int change2D(int total, int[] coins) {
        if (total == 0){
            return 1;
        } else if(coins == null || coins.length == 0){
            return 0;
        }
        int n = coins.length;
        int[][] dp = new int[n][total + 1];

        // populate the total=0 columns, as we will always have an empty set for zero toal
        for(int i=0; i < n; i++)
            dp[i][0] = 1;

        // process all sub-arrays for all capacities
        for(int i=0; i < n; i++) {
            for(int c=1; c <= total; c++) {
                if(i > 0) // for second coins onward (use without picking count) without
                    dp[i][c] = dp[i-1][c];
                if(c >= coins[i]) // if you can include the coin, (include the values as well) with
                    dp[i][c] += dp[i][c-coins[i]];
            }
        }

        // total combinations will be at the bottom-right corner.
        return dp[n-1][total];
    }

    /**
     * Recursive solution with memoization
     * @param denominations
     * @param total
     * @return
     */
    public int countChange(int[] denominations, int total)
    {
        Integer[][] dp = new Integer[denominations.length][total + 1];
        return this.countChangeRecursive(dp, denominations, total, 0);
    }

    private int countChangeRecursive(Integer[][] dp, int[] denominations, int total, int currentIndex)
    {
        // base checks
        if (total == 0)
            return 1;

        if(denominations.length == 0 || currentIndex >= denominations.length)
            return 0;

        // if we have already processed a similar sub-problem, return the result from memory
        if(dp[currentIndex][total] != null)
            return dp[currentIndex][total];

        // recursive call after selecting the coin at the currentIndex
        // if the number at currentIndex exceeds the total, we shouldn't process this {{ current index NOT INCREMENTED}}
        int sum1 = 0;
        if( denominations[currentIndex] <= total )
            sum1 = countChangeRecursive(dp, denominations, total - denominations[currentIndex], currentIndex);

        // recursive call after excluding the number at the currentIndex
        int sum2 = countChangeRecursive(dp, denominations, total, currentIndex + 1);

        dp[currentIndex][total] = sum1 + sum2;
        return dp[currentIndex][total];
    }
}
