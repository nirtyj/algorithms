package com.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.leetcode.easy.FindAllNumbersDisappeared;

public class FindAllNumbersDisappearedTest {

	@Test
	public void test() {
		int[] arr = {4,3,2,7,8,2,3,1};
		List<Integer> result = FindAllNumbersDisappeared.findDisappearedNumbers(arr);
		assertEquals(2, result.size());
	}

}
