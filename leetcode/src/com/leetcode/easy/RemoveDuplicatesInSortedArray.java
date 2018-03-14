package com.leetcode.easy;

/**
Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example:

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
It doesn't matter what you leave beyond the new length.
*/
public class RemoveDuplicatesInSortedArray {

	/**
	 * Leetcode verified
	 * 
	 * @param nums
	 * @return
	 */
	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 1)
			return 1;

		int i = 0;
		int currIndex = 0;
		while (i < nums.length) {
			nums[currIndex] = nums[i];
			while (i < nums.length && nums[currIndex] == nums[i])
				i++;

			currIndex++;
		}
		return currIndex;
	}
}
