package com.leetcode.medium;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IncreasingTripletSequenceTest {

	@Test
	public void test() {
		int[] nums = { 2, 1, 5, 0, 4, 6};
		IncreasingTripletSequence seq = new IncreasingTripletSequence();
		assertTrue(seq.increasingTriplet(nums));
	}
}
