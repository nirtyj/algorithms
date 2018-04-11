package com.leetcode.medium;

import java.util.HashMap;

/**
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
*/
public class SubarraySumEqualsK {

	/**
	 * Leetcode verified - O(n) O(k)
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int subarraySum(int[] nums, int k) {
		int count = 0, sum = 0;
		// map of sum to the number of times it has been seen before.
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];

			if (sum == k)
				count += 1;

			// if the diff is there, increment count + that many times of that sum
			if (map.containsKey(sum - k))
				count += map.get(sum - k);

			// put whatever you have seen + 1 count for that sum
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}

	/**
	 * Leetcode verified - N^2
	 * @param nums
	 * @param k
	 * @return
	 */
	public int subarraySumMemoization(int[] nums, int k) {
		int mem[] = new int[nums.length];
		mem[0] = nums[0];
		int count = 0;
		if (mem[0] == k)
			count++;

		for (int end = 1; end < nums.length; end++) {
			mem[end] = mem[end - 1] + nums[end];
			if (mem[end] == k)
				count++;
		}

		for (int start = 1; start < nums.length; start++) {
			for (int end = start; end < nums.length; end++) {
				int sum = mem[end] - nums[start - 1];

				if (sum == k)
					count++;

				mem[end] = sum;
			}
		}
		return count;
	}
	 
	/**
	 * Bruteforce - N^3  - Time limit exceeded
	 * @param nums
	 * @param k
	 * @return
	 */
	public int subarraySumBrute(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return 0;
		int count = 0;
		for (int start = 0; start < nums.length; start++) {
			for (int end = start; end < nums.length; end++) {
				int sum = 0;
				for (int i = start; i <= end; i++) {
					sum = sum + nums[i];
				}
				if (sum == k)
					count++;
			}
		}
		return count;
	}
}
