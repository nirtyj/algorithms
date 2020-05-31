package com.leetcode.dp.zerooneknapsack;

/**
 * Given a set of positive numbers, determine if there exists a subset whose sum is equal to a given number ‘S’.
 * Input: {1, 2, 3, 7}, S=6
 * Output: True
 * The given set has a subset whose sum is '6': {1, 2, 3}
 *
 * 416. Partition Equal Subset Sum
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 * Note:
 *
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 */
public class SubsetSum {
    public boolean canPartition(int[] num, int sum) {
        int n = num.length;
        boolean[][] dp = new boolean[n][sum + 1];

        // populate the sum=0 columns, as we can always form '0' sum with an empty set
        for (int i = 0; i < n; i++)
            dp[i][0] = true;

        // first element
        dp[0][num[0]] = true;

        for (int i = 1; i < num.length; i++) {
            for (int c = 0; c <= sum; c++) {
                boolean without = dp[i - 1][c];
                boolean with = false;
                if (num[i] < c) {
                    int withRemC = c - num[i];
                    with = dp[i - 1][withRemC];
                }
                dp[i][c] = with | without;
                if (dp[i][c] && c == sum)
                    return true;
            }
        }
        return false;
    }

    public boolean canPartitionOptimized(int[] num, int sum) {
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0; i < num.length; i++) {
            // go from right to left so that we don't overwrite !! fuck why this kolaveri?
            for (int c = sum; c >= 0; c--) {
                boolean without = dp[c];
                boolean with = false;
                if (c == num[i]) {
                    with = true;
                } else if (c > num[i]) {
                    with = dp[c - num[i]];
                }
                dp[c] = with | without;
                if (dp[c] && c == sum)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SubsetSum ss = new SubsetSum();
        int[] num = {1, 2, 3, 7};
        System.out.println(ss.canPartitionOptimized(num, 6));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ss.canPartitionOptimized(num, 10));
        num = new int[]{1, 3, 4, 8};
        System.out.println(ss.canPartitionOptimized(num, 6));
    }
}