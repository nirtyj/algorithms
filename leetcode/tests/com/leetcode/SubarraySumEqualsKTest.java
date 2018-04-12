package com.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leetcode.subarrays.SubarraySumEqualsK;

public class SubarraySumEqualsKTest {

	@Test
	public void test() {
		int[] nums = { 1,2,1,2,1};
		assertEquals(4, SubarraySumEqualsK.subarraySum(nums, 3));
	}

}
