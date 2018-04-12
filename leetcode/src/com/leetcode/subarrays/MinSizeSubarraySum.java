package com.leetcode.subarrays;

import java.util.LinkedHashMap;

/**
Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
*/
public class MinSizeSubarraySum {

	/**
	 * Leetcode verified
	 * @param s
	 * @param nums
	 * @return
	 */
	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
		while (j < nums.length) {
			sum = sum + nums[j];
			j++;

			while (sum >= s) {
				min = Math.min(min, j - i);
				sum = sum - nums[i];
				i++;
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}

	/**
	 * Time limit exceeded
	 * @param s
	 * @param nums
	 * @return
	 */
	public int minSubArrayLenTLE(int s, int[] nums) {
		LinkedHashMap<Integer, Integer> sumToPos = new LinkedHashMap<>();
		int sum = 0;
		int previousIndex = -1;
		int minLength = Integer.MAX_VALUE;
		int minSum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			if (i == 0)
				minSum = sum;
			if (sum >= s) {
				int key = sum - s;
				while (key >= minSum) {
					if (sumToPos.containsKey(key)) {
						previousIndex = Math.max(previousIndex, sumToPos.get(key));
						break;
					}
					key--;
				}

				minLength = Math.min(minLength, i - previousIndex);	
			}
			sumToPos.put(sum, i);
		}
		if (minLength == Integer.MAX_VALUE)
			return 0;
		return minLength;
	}
}
