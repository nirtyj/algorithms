package com.leetcode.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Leetcode verified
 * @author njaganathan
 *
 */
public class ThreeSum {
	public static List<List<Integer>> threeSum(int[] nums) {
		return threeSumHelper(nums, 0);
	}

	public static List<List<Integer>> threeSumHelper(int[] nums, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (nums == null || nums.length < 3)
			return result;

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			// removes duplicates while starting with same integer val
			if (i == 0 || nums[i] > nums[i - 1]) {
				int j = i + 1;
				int k = nums.length - 1;

				while (j < k) {
					if (nums[i] + nums[j] + nums[k] == sum) {
						List<Integer> l = new ArrayList<Integer>();
						l.add(nums[i]);
						l.add(nums[j]);
						l.add(nums[k]);
						result.add(l);

						j++;
						k--;

						// handle duplicate here for other numbers
						// if same number as previous, increment if its l, or decrement if its r
						while (j < k && nums[j] == nums[j - 1])
							j++;
						while (j < k && nums[k] == nums[k + 1])
							k--;

					} else if (nums[i] + nums[j] + nums[k] < 0) {
						j++;
					} else {
						k--;
					}
				}
			}

		}

		return result;
	}
}