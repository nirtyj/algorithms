package com.leetcode.sliding_window;

/**
 * You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the
 * rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.
 *
 * Return the minimum number of operations to reduce x to exactly 0 if it's possible, otherwise, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,4,2,3], x = 5
 * Output: 2
 * Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
 * Example 2:
 *
 * Input: nums = [5,6,7,8,9], x = 4
 * Output: -1
 * Example 3:
 *
 * Input: nums = [3,2,20,1,1,3], x = 10
 * Output: 5
 * Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
 */
public class MinimumOperationstoReduceXtoZero_LC1658 {

    /**
     * Sliding window similar to LC1423
     * @param nums
     * @param x
     * @return
     */
    public int minOperations(int[] nums, int x) {
        int left = 0;
        double sum = 0;
        int min = Integer.MAX_VALUE;
        while (left < nums.length && (sum + nums[left]) <= x) {
            sum = sum + nums[left];
            left++;
        }
        if (sum == x) {
            min = Math.min(min, left);
        }
        for (int right = nums.length - 1; right >= left && sum <= x; right--) {
            sum = sum + nums[right];
            if (sum == x) {
                min = Math.min(min, left + 1 + (nums.length - 1 - right));
            }
            while (sum >= x && left > 0) {
                left--;
                sum = sum - nums[left];
                if (sum == x) {
                    min = Math.min(min, left + 1 + (nums.length - 1 - right));
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
