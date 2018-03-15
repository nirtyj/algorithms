package com.leetcode.medium;

import java.util.HashMap;

/**
Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.

Example 1:
Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
Example 2:
Input: [23, 2, 6, 4, 7],  k=6
Output: True
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
*/
public class ContinuousSubarraySum {

	/**
	 * O(n)
	 * @param nums
	 * @param k
	 * @return
	 */
	public static boolean checkSubarraySum(int[] nums, int k) {
		int sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		for (int i = 0; i < nums.length; i++) {
			//calculate running sum
			sum += nums[i];
			// find the mod
			if (k != 0)
				sum = sum % k;
			// if there exists a previous value
			if (map.containsKey(sum)) {
				// check if the index diff is more than 1
				if (i - map.get(sum) > 1)
					return true;
			} else
				// sum and its index
				map.put(sum, i);
		}
		return false;
	}
	
	/**
	 * Leetcode accepted - N^2 algorithm with caching
	 * @param nums
	 * @param k
	 * @return
	 */
	public boolean checkSubarraySum2(int[] nums, int k) {
		int mem[] = new int[nums.length];
		mem[0] = nums[0];
		for (int end = 1; end < nums.length; end++) {
			mem[end] = mem[end - 1] + nums[end];
			if (mem[end] == k || (k != 0 && mem[end] % k == 0))
				return true;
		}

		for (int start = 1; start < nums.length; start++) {
			for (int end = start + 1; end < nums.length; end++) {
				int sum = mem[end] - nums[start - 1];

				if (sum == k || (k != 0 && sum % k == 0))
					return true;

				mem[end] = sum;
			}
		}
		return false;
	}
	
	/**
	 * N^3 brute force
	 * @param nums
	 * @param k
	 * @return
	 */
	public boolean checkSubarraySum3(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return false;

		for (int start = 0; start < nums.length; start++) {
			for (int end = start + 1; end < nums.length; end++) {
				int sum = 0;
				for (int i = start; i <= end; i++) {
					sum = sum + nums[i];
				}
				if (sum == k || (k != 0 && sum % k == 0))
					return true;
			}
		}
		return false;
	}
}
