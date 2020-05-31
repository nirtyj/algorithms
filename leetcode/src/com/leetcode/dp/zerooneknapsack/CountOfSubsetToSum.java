package com.leetcode.dp.zerooneknapsack;

/**
 * Given a set of positive numbers, find the total number of subsets whose sum is equal to a given number ‘S’.
 *
 * Example 1:
 * Input: {1, 1, 2, 3}, S=4
 * Output: 3
 * The given set has '3' subsets whose sum is '4': {1, 1, 2}, {1, 3}, {1, 3}
 * Note that we have two similar sets {1, 3}, because we have two '1' in our input.
 */
public class CountOfSubsetToSum {

    public int countSubsets(int[] nums, int sum) {
        int[][] dp = new int[nums.length][sum + 1];

        // populate the sum=0 columns, as we will always have an empty set for zero sum
        for (int i = 0; i < nums.length; i++)
            dp[i][0] = 1;

        // initialize first row
        if (nums[0] <= sum)
            dp[0][nums[0]] = 1;

        // process all subsets for all sums
        for (int i = 1; i < nums.length; i++) {
            for (int c = 1; c <= sum; c++) {
                int total = 0;
                // with out
                total = total + dp[i - 1][c];
                // include the number, if it does not exceed the capacity
                if ((nums[i] <= c)) {
                    total = total + (dp[i - 1][c - nums[i]]);
                }
                dp[i][c] = total;
            }
        }
        // the bottom-right corner will have our answer.
        return dp[nums.length - 1][sum];
    }

    public static void main(String[] args) {
        CountOfSubsetToSum ss = new CountOfSubsetToSum();
        int[] num = {1, 1, 2, 3};
        System.out.println(ss.countSubsets(num, 4));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ss.countSubsets(num, 9));
    }
}
