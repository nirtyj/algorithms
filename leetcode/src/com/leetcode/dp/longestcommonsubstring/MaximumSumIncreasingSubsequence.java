package com.leetcode.dp.longestcommonsubstring;

public class MaximumSumIncreasingSubsequence {

    /**
     * Bottom up DP N*N
     * @param nums
     * @return
     */
    public int findMSIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxVal = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i] = nums[i];
            for(int j=0;j<i;j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + nums[i]);
                }
            }
            maxVal = Math.max(maxVal, dp[i]);
        }
        return maxVal;
    }

    /**
     * Recursion with memoization
     * @param nums
     * @return
     */
    public int findMSISRecurseMemoization(int[] nums) {
        return recurseHelper(nums, 0, -1, 0, new Integer[nums.length][nums.length+1]);
    }

    private int recurseHelper(int[] nums, int current, int previous, int sum, Integer[][] memo){
        if (current >= nums.length){
            return sum;
        }
        if (memo[current][previous+1] != null){
            return memo[current][previous+1];
        }
        int c1 = sum;
        if (previous == -1 || nums[current] > nums[previous]){
            c1 = nums[current] + recurseHelper(nums, current + 1, current,  sum + c1, memo);
        }
        int c2 = recurseHelper(nums, current + 1, previous,  sum, memo);
        memo[current][previous+1] = Math.max(c1, c2);
        return memo[current][previous+1];
    }

    public static void main(String[] args) {
        MaximumSumIncreasingSubsequence msis = new MaximumSumIncreasingSubsequence();
        int[] nums = {4,1,2,6,10,1,12};
        System.out.println(msis.findMSISRecurseMemoization(nums));
        nums = new int[]{-4,10,3,7,15};
        System.out.println(msis.findMSISRecurseMemoization(nums));
    }
}
