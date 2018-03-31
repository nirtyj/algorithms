package com.leetcode.easy;

/**
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
*/
public class MaximumSubarraySum {
	
	/**
	 * Leetcode verified - Kadane's Algorithm
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {

		int max = Integer.MIN_VALUE;
		int maxTillHere = 0;
		for (int i = 0; i < nums.length; i++) {
			// whenever max till here goes into negative, reset the maxtill here to
			// current value
			if (maxTillHere < 0 && maxTillHere < nums[i]) {
				maxTillHere = nums[i];
			} else {
				// find the total sum always
				maxTillHere += nums[i];
			}
			// update the max
			max = Math.max(max, maxTillHere);
		}
		return max;
	}
}
