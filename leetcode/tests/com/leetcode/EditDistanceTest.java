package com.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leetcode.hard.EditDistance;

public class EditDistanceTest {

	@Test
	public void test() {
		assertEquals(1, EditDistance.minDistance("", "a"));
	}

}
