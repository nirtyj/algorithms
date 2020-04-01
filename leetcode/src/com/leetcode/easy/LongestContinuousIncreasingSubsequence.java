package com.leetcode.easy;

/**
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
 * <p>
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
 * Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 1
 * Explanation: The longest continuous increasing subsequence is [2], its length is 1.
 */
public class LongestContinuousIncreasingSubsequence {

    /**
     * Leetcode verified
     *
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int length = 1;
        int tmp = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                tmp++;
                length = Math.max(length, tmp);
            } else if (nums[i] >= nums[i + 1]) {
                tmp = 1;
            }
        }
        return length;
    }
}
