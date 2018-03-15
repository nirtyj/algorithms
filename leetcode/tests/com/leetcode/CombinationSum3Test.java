package com.leetcode;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.leetcode.subsets_combinations.CombinationSum3;

public class CombinationSum3Test {

	@Test
	public void test() {
		List<List<Integer>> result = CombinationSum3.combinationSum3(3, 7);
		List<List<Integer>> goldenResult = Arrays.asList(Arrays.asList(1, 2, 4));
		assertTrue(result.equals(goldenResult));
	}

	@Test
	public void test2() {
		List<List<Integer>> result = CombinationSum3.combinationSum3(3, 9);
		List<List<Integer>> goldenResult = Arrays.asList(Arrays.asList(1, 2, 6), Arrays.asList(1, 3, 5),
				Arrays.asList(2, 3, 4));
		assertTrue(result.equals(goldenResult));
	}

}
