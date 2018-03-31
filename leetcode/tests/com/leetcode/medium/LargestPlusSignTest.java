package com.leetcode.medium;

import static org.junit.Assert.*;

import org.junit.Test;

public class LargestPlusSignTest {

	@Test
	public void test() {
		LargestPlusSign sign = new LargestPlusSign();
		int[][] mines = {{4,2}};
		assertEquals(2, sign.orderOfLargestPlusSign(5, mines));
	}

}
