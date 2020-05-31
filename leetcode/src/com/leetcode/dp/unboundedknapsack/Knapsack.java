package com.leetcode.dp.unboundedknapsack;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given two integer arrays to represent weights and profits of ‘N’ items,
 * we need to find a subset of these items which will give us maximum profit such that their
 * cumulative weight is not more than a given number ‘C’.
 * We can assume an infinite supply of item quantities; therefore, each item can be selected multiple times.
 *
 * Items: { Apple, Orange, Melon }
 * Weights: { 1, 2, 3 }
 * Profits: { 15, 20, 50 }
 * Knapsack capacity: 5
 *
 * Given a rod of length ‘n’, we are asked to cut the rod and sell the pieces in a way that will maximize the profit.
 * We are also given the price of every piece of length ‘i’ where ‘1 <= i <= n’.
 *
 * Example:
 *
 * Lengths: [1, 2, 3, 4, 5]
 * Prices: [2, 6, 7, 10, 1
 */
public class Knapsack {

    /**
     * Recursive with memoization
     * @param profits
     * @param weights
     * @param capacity
     * @return
     */
    public int solveKnapsackMemoized(int[] profits, int[] weights, int capacity) {
        Integer[][] dp = new Integer[profits.length][capacity + 1];
        return this.knapsackRecursive(dp, profits, weights, capacity, 0);
    }

    private int knapsackRecursive(Integer[][] dp, int[] profits, int[] weights, int capacity, int i) {
        if (capacity == 0 || i >= dp.length) {
            return 0;
        }
        if (dp[i][capacity] ==null) {
            int withOut = knapsackRecursive(dp, profits, weights, capacity, i+1);
            int with = 0;
            if (weights[i] <= capacity) {
                // recursive call after choosing the items at the currentIndex, note that we recursive call on all
                // items as we did not increment currentIndex
                with =  profits[i] + knapsackRecursive(dp, profits, weights, capacity - weights[i], i);
            }
            dp[i][capacity] = Math.max(with, withOut);
        }
        return dp[i][capacity];
    }

    /**
     * Bottom up O(N * C) space and time.
     * @param profits
     * @param weights
     * @param capacity
     * @return
     */
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        // base checks
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;

        int[][] dp = new int[profits.length][capacity + 1];

        // populate the capacity=0 columns
        for (int i = 0; i < profits.length; i++)
            dp[i][0] = 0;

        // process all sub-arrays for all capacities
        for (int i = 0; i < profits.length; i++) {
            for (int c = 1; c <= capacity; c++) {
                int without = 0, with = 0;
                if (i > 0)
                    without = dp[i - 1][c];
                if (weights[i] <= c)
                    with = profits[i] + dp[i][c - weights[i]];
                dp[i][c] = Math.max(with, without);
            }
        }
        ArrayList<Integer> elements = pickElementsKnapsack(dp, profits, weights);

        System.out.println("Elements: "+ Arrays.toString(elements.toArray()));

        // maximum profit will be in the bottom-right corner.
        return dp[profits.length - 1][capacity];
    }

    public ArrayList<Integer> pickElementsKnapsack(int[][] dp, int[] profits, int[] weights){
        ArrayList<Integer> result = new ArrayList<>();
        int i = dp.length -1;
        int j = dp[0].length-1;
        while(i-1>=0 && j>0 && dp[i][j] != 0){
            while ( i-1>=0 && dp[i][j] == dp[i-1][j]){
                i--;
            }
            result.add(weights[i]);
            int newSum = dp[i][j] - profits[i];
            while(j>0){
                j--;
                if (dp[i][j] == newSum){
                    break;
                }
            }
        }
       return result;
    }


    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = {15, 50, 60, 90};
        int[] weights = {1, 3, 4, 5};
        System.out.println(ks.solveKnapsack(profits, weights, 8));
        System.out.println(ks.solveKnapsack(profits, weights, 6));
        System.out.println(ks.solveKnapsackMemoized(profits, weights, 8));
        System.out.println(ks.solveKnapsackMemoized(profits, weights, 6));

        int[] prices = {2, 6, 7, 10, 13};
        int[] lengths = {1, 2, 3, 4, 5};
        System.out.println(ks.solveKnapsack(prices, lengths, 5));
        System.out.println(ks.solveKnapsackMemoized(prices, lengths, 5));
    }
}
