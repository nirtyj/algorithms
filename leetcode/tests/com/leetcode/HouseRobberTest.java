package com.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leetcode.easy.HouseRobber;

public class HouseRobberTest {

	@Test
	public void test() {
		int[] arr = {2,7,9,3,1};
		assertEquals(12, HouseRobber.rob(arr));
	}

}
