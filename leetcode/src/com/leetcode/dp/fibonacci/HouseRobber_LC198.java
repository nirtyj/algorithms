package com.leetcode.dp.fibonacci;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber_LC198 {

    /**
     * Leetcode verified O(n) with constant space
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if (nums.length == 0){
            return 0;
        } else if (nums.length == 1){
            return nums[0];
        } else if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int nminus2 = nums[0];
        int nminus1 = Math.max(nums[0], nums[1]);
        int max = Math.max(nums[0], nums[1]);
        for(int i=2;i<nums.length;i++){
            int temp = Math.max(nminus1, nums[i] + nminus2);
            nminus2 = nminus1;
            nminus1 = temp;
            max = Math.max(max, temp);
        }
        return max;
    }
}
