package com.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leetcode.dp.DecodeWays;

public class DecodeWaysTest {

	@Test
	public void test() {
		DecodeWays ways = new DecodeWays();
		assertEquals(2, ways.numDecodings("11"));
	}

}
