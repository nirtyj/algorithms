package com.leetcode.binarysearch;

/**
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/
public class FindMinSortedRotatedArray {

	/**
	 * Leetcode verified
	 * 
	 * @param list
	 * @return
	 */
	public static int findMin(int[] list) {
		int left = 0;
		int right = list.length - 1;

		while (left < right) {
			int middle = left + (right - left) / 2;
			if (list[middle] > list[right]) {
				left = middle + 1;
			} else {
				right = middle;
			}
		}
		return list[left];
	}

	/**
	 * Leetcode verified
	 */
	public int findMinOther(int[] nums) {
		if (nums == null || nums.length == 0)
			return -1;

		if (nums.length == 1)
			return nums[0];

		int left = 0;
		int right = nums.length - 1;

		// not rotated
		if (nums[left] < nums[right])
			return nums[left];

		while (left <= right) {
			if (right - left == 1) {
				return nums[right];
			}

			int m = left + (right - left) / 2;

			if (nums[m] > nums[right])
				left = m;
			else
				right = m;
		}

		return nums[left];
	}
}
