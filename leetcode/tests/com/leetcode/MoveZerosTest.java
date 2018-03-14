package com.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import com.leetcode.easy.MoveZeros;

public class MoveZerosTest {

	@Test
	public void test() {
		int[] arr = {0,1,0,3,12};
		MoveZeros.moveZeroes(arr);
		assertEquals("[1, 3, 12, 0, 0]",Arrays.toString(arr));
	}

}
