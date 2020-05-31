package com.leetcode.dp.zerooneknapsack;

/**
 * Given a set of positive numbers,
 * find if we can partition it into two subsets such that the sum of elements in both the subsets is equal.
 * Input: {1, 2, 3, 4}
 * Output: True
 * Explanation: The given set can be partitioned into two subsets with equal sum: {1, 4} & {2, 3}
 */
public class PartitionEqualSubsetSum {

    /**
     * Bottom up DP with Space optimization
     * @param nums
     * @return
     */
    public boolean canPartitionOptimized(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int n : nums){
            sum += n;
        }
        if (sum %2 != 0){
            return false;
        }

        boolean[] dp = new boolean[(sum / 2) + 1];
        dp[0] = true;

        for(int i=0;i<nums.length;i++){
            for(int c=sum/2; c>=0;c--) {
                boolean without = dp[c];
                boolean with = false;
                if (c == nums[i]){
                    with = true;
                }
                else if (c > nums[i]){
                    int withRemC = c - nums[i];
                    with = dp[withRemC];
                }
                dp[c] = with | without;
                if (dp[c] && c==sum / 2){
                    return true;
                }
            }
        }
        return false;

    }

    /**
     * Bottom up DP
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) {
            return false;
        }

        boolean[][] dp = new boolean[nums.length][(sum / 2) + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }

        if (nums[0] <= sum / 2)
            dp[0][nums[0]] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int c = 0; c <= sum / 2; c++) {
                boolean without = dp[i - 1][c];
                boolean with = false;
                if (c > nums[i]) {
                    int withRemC = c - nums[i];
                    with = dp[i - 1][withRemC];
                }
                dp[i][c] = with | without;
                if (dp[i][c] && c == sum / 2) {
                    return true;
                }
            }
        }
        return false;

    }
}
