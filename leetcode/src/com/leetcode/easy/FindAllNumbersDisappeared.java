package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappeared {

	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> ret = new ArrayList<Integer>();

		for (int i = 0; i < nums.length; i++) {
			// consider each val as index and negate the value thats on that index only if its positive
			// abs value here beacuase, you are working on the same array as the negated one.
			// check if its positive because, the val as index might already be visited and negated before
			int val = Math.abs(nums[i]) - 1;
			if (nums[val] > 0) {
				nums[val] = -nums[val];
			}
		}
		
		// count how many non - negated vals. Means that these are missing and have not been visited
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				ret.add(i + 1);
			}
		}
		return ret;
	}
}
