package com.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leetcode.hard.TrappingRainWater;

public class TrappingRainWaterTest {

	@Test
	public void test() {
		int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
		assertEquals(6, TrappingRainWater.trap(input));
	}

}
