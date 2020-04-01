package com.leetcode.binarysearch;

/**
 * Follow up for "Find Minimum in Rotated Sorted Array":
 * What if duplicates are allowed?
 * <p>
 * Would this affect the run-time complexity? How and why?
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * Find the minimum element.
 * <p>
 * The array may contain duplicates.
 */
public class FindMinSortedRotatedArray2 {

    /**
     * Leetcode verified
     *
     * @param list
     * @return
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            // handle cases like [3, 1, 3]
            while (nums[left] == nums[right] && left != right) {
                left++;
            }

            if (nums[left] <= nums[right]) {
                return nums[left];
            }

            int middle = (left + right) / 2;
            if (nums[middle] >= nums[left]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return -1;
    }
}