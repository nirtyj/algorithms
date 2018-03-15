package com.leetcode;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.leetcode.medium.ContinuousSubarraySum;

public class ContinuousSubarraySumTest {

	@Test
	public void test() {
		int nums[] = { 0, 1, 0 };
		assertFalse(ContinuousSubarraySum.checkSubarraySum(nums, 0));
	}

}
