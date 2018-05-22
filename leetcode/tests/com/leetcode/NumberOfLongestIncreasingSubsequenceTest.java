package com.leetcode;

import org.junit.Test;

import com.leetcode.dp.NumberOfLongestIncreasingSubsequence;

public class NumberOfLongestIncreasingSubsequenceTest {

	@Test
	public void test() {
		int[] nums = { 1, 3, 5, 4, 7 };
		int val = NumberOfLongestIncreasingSubsequence.findNumberOfLIS(nums);
	}

	@Test
	public void test1() {
		int[] nums = { 1, 2, 3, 1, 2, 3, 1, 2, 3 };
		int val = NumberOfLongestIncreasingSubsequence.findNumberOfLIS(nums);
	}

}
