package com.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leetcode.medium.NextClosestTime;

public class NextClosestTimeTest {

	@Test
	public void test() {
		NextClosestTime time = new NextClosestTime();
		assertEquals("19:39", time.nextClosestTime("19:34"));
	}

	@Test
	public void test1() {
		NextClosestTime time = new NextClosestTime();
		assertEquals("21:51", time.nextClosestTime("21:45"));
	}
}
