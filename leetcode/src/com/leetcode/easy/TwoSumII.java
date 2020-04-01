package com.leetcode.easy;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * <p>
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * <p>
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class TwoSumII {

    /**
     * Leetcode verified
     *
     * @param numst
     * @param target
     * @return
     */
    public int[] twoSumVals(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int[] result = new int[2];

        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                break;
            } else if (sum > target) {
                j--;
            } else
                i++;
        }
        return result;
    }
}
