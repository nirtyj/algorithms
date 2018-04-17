package com.leetcode.medium;

import static org.junit.Assert.*;

import org.junit.Test;

import com.leetcode.subarrays.ContiguousBinaryArray;

public class FindMaxLengthTest {

	@Test
	public void test() {
		int[] arr = {0, 1,1};
		ContiguousBinaryArray m = new ContiguousBinaryArray();
		assertEquals(2, m.findMaxLength(arr));
	}

}
