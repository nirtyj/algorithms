package com.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leetcode.hard.LargestRectangleInHistogram;

public class LargestHistogramRectangleTest {

	@Test
	public void test() {
		int[] input = {2,1,5,6,2,3};
		assertEquals(10, LargestRectangleInHistogram.largestRectangleArea(input));
	}

}
