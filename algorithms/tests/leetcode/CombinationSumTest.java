package leetcode;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CombinationSumTest {

	@Test
	public void test() {
		Integer[] input = { 2, 3, 6, 7 };
		List<Integer> inputList = Arrays.asList(input);
		List<List<Integer>> result = CombinationSum.combinationSum(inputList, 7);
		List<List<Integer>> goldenResult = Arrays.asList(Arrays.asList(2, 2, 3), Arrays.asList(7));
		assertTrue(result.equals(goldenResult));
	}

}
