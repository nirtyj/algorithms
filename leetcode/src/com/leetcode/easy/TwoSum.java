package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.
*/
public class TwoSum {

	/**
	 * Leetcode verified
	 * O(n)
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	/**
	 * Returns the value of elements. not index! O(n log n)
	 * Not verified
	 * @param numst
	 * @param target
	 * @return
	 */
	public int[] twoSumVals(int[] nums, int target) {
		Arrays.sort(nums);
		int i = 0;
		int j = nums.length - 1;
		int[] result = new int[2];

		while (j > 0) {
			if (nums[j] > target) {
				j--;
			} else {
				break;
			}
		}

		while (i <= j) {
			int sum = nums[i] + nums[j];
			if (sum == target) {
				result[0] = nums[i];
				result[1] = nums[j];
				break;
			} else if (sum > target) {
				j--;
			} else
				i++;
		}
		return result;
	}
}
