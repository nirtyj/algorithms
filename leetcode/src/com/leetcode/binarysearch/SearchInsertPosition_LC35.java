package com.leetcode.binarysearch;

import java.util.Arrays;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 *
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 * Example 4:
 *
 * Input: nums = [1,3,5,6], target = 0
 * Output: 0
 */
public class SearchInsertPosition_LC35 {

    /**
     *  minimal k value satisfying nums[k] >= target
     * @param nums
     * @param target
     * @return
     */
    public int searchInsertImpl(int[] nums, int target) {
        int left = 0;
        // notice that the input target might be larger than all elements in nums and
        // therefore needs to placed at the end of the array.
        // That's why we should initialize right = len(nums) instead of right = len(nums) - 1
        int right = nums.length;
        while(left < right){
            int middle = left + (right - left) / 2;
            if (nums[middle] >= target){
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    /**
     * Using built in functions
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int val = Arrays.binarySearch(nums, target);
        return (val < 0) ? -val - 1 : val;
    }
}
