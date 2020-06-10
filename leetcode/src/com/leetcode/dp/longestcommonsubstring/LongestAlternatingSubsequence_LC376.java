package com.leetcode.dp.longestcommonsubstring;

/**
 * Problem Statement #
 * Given a number sequence, find the length of its Longest Alternating Subsequence (LAS). A subsequence is considered alternating if its elements are in alternating order.
 *
 * A three element sequence (a1, a2, a3) will be an alternating sequence if its elements hold one of the following conditions:
 *
 * {a1 > a2 < a3 } or { a1 < a2 > a3}.
 * Example 1:
 *
 * Input: {1,2,3,4}
 * Output: 2
 * Explanation: There are many LAS: {1,2}, {3,4}, {1,3}, {1,4}
 * Example 2:
 *
 * Input: {3,2,1,4}
 * Output: 3
 * Explanation: The LAS are {3,2,4} and {2,1,4}.
 * Example 3:
 *
 * Input: {1,3,2,4}
 * Output: 4
 * Explanation: The LAS is {1,3,2,4}.
 */
public class LongestAlternatingSubsequence_LC376 {

    /**
     * O(n)
     *
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        return 1 + Math.max(recurseHelper(nums, 1, 0, true), recurseHelper(nums, 1, 0, false));
    }

    public int recurseHelper(int[] nums, int current, int prev, boolean positive) {
        if (current < 0 || current >= nums.length || prev < 0 || prev >= nums.length) {
            return 0;
        }
        if (positive) {
            if (nums[prev] > nums[current]) {
                return 1 + recurseHelper(nums, current + 1, current, !positive);
            } else {
                return recurseHelper(nums, current + 1, current, positive);
            }

        } else {
            if (nums[prev] < nums[current]) {
                return 1 + recurseHelper(nums, current + 1, current, !positive);
            } else {
                return recurseHelper(nums, current + 1, current, positive);
            }
        }
    }
}
