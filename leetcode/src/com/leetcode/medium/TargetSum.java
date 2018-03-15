package com.leetcode.medium;

import java.util.Arrays;

/**
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:
The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.
*/
public class TargetSum {
	
	int count = 0;

	/**
	 * Leetcode accepted - 
	 * Memoization - calculate only for one part of the subtree. as its repeated work
	 * @param nums
	 * @param S
	 * @return
	 */
	public int findTargetSumWaysMemo(int[] nums, int S) {
		count = 0;
		if (nums == null || nums.length == 0)
			return 0;
		int[][] memo = new int[nums.length][2001];
		for (int[] row : memo)
			Arrays.fill(row, Integer.MIN_VALUE);
		return getCount(0, nums, S, 0, memo);
	}

	public int getCount(int index, int[] nums, int S, int currentSum, int[][] memo) {
		if (index == nums.length) {
			if (currentSum == S)
				return 1;
			else
				return 0;
		}

		if (memo[index][currentSum + 1000] != Integer.MIN_VALUE) {
			return memo[index][currentSum + 1000];
		}

		int add = getCount(index + 1, nums, S, currentSum + nums[index], memo);
		int sub = getCount(index + 1, nums, S, currentSum - nums[index], memo);
		memo[index][currentSum + 1000] = add + sub;
		return memo[index][currentSum + 1000];
	}

	/**
	 * DP - Same as knapsack
	 * https://discuss.leetcode.com/assets/uploads/files/1485048726667-screen-shot-2017-01-21-at-8.31.48-pm.jpg
	 * @param nums
	 * @param s
	 * @return
	 */
	public int findTargetSumWays(int[] nums, int S) {

		int sum = 0;
		for (int n : nums) {
			sum += n;
		}
		if (S < -sum || S > sum) {
			return 0;
		}

		int[][] dp = new int[nums.length + 1][2 * sum + 1];
		dp[0][0 + sum] = 1; // 0 + sum means 0, 0 means -sum, check below graph
		for (int i = 1; i <= nums.length; i++) {
			for (int j = 0; j < 2 * sum + 1; j++) {

				if (j + nums[i - 1] < 2 * sum + 1)
					dp[i][j] += dp[i - 1][j + nums[i - 1]];
				if (j - nums[i - 1] >= 0)
					dp[i][j] += dp[i - 1][j - nums[i - 1]];
			}
		}
		return dp[nums.length][sum + S];
	}
	
	/**
	 * Leetcode verified - Brute force - 2^n
	 */
	public int findTargetSumWaysBrute(int[] nums, int S) {
		count = 0;
		if (nums == null || nums.length == 0)
			return 0;
		recurseHelperBrute(0, nums, S, 0);
		return count;
	}

	private void recurseHelperBrute(int index, int[] nums, int S, int currentSum) {
		if (index == nums.length) {
			if (currentSum == S)
				count++;
			return;
		}
		recurseHelperBrute(index + 1, nums, S, currentSum + nums[index]);
		recurseHelperBrute(index + 1, nums, S, currentSum - nums[index]);
	}
}
