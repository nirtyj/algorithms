package com.leetcode.bitmanipulation;

/**
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 */
public class SingleNumber {

	/**
	 * Leetcode verified
	 * 
	 * @param nums
	 * @return
	 */
	int singleNumber(int nums[]) {
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			result = result ^ nums[i];
		}
		return result;
	}
}
