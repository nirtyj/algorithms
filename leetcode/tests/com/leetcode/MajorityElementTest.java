package com.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.leetcode.medium.MajorityElementII;

public class MajorityElementTest {

	@Test
	public void test() {
		int[] input = {2, 2};
		List<Integer> results = MajorityElementII.majorityElement(input);
		assertEquals(2, results.get(0).intValue());
	}

	@Test
	public void test2() {
		int[] input = {1, 2};
		List<Integer> results = MajorityElementII.majorityElement(input);
		assertEquals(1, results.get(0).intValue());
		assertEquals(2, results.get(1).intValue());
	}
}
