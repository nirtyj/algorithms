package com.leetcode.easy;

/**
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/
public class MoveZeros {

	/**
	 * Leetcode verified
	 * @param nums
	 */
	public static void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1)
			return;

		int count = 0;
		int currIndex = 0;
		int nextIndex = 0;
		while (nextIndex < nums.length) {
			while (nextIndex < nums.length && nums[nextIndex] == 0) {
				count++;
				nextIndex++;
			}
			if (nextIndex >= nums.length)
				break;
			nums[currIndex] = nums[nextIndex];
			currIndex++;
			nextIndex++;
		}

		for (int i = nums.length - 1; count > 0; i--) {
			nums[i] = 0;
			count--;
		}
	}
}
