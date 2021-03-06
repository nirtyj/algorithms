package com.leetcode;

import com.leetcode.subsets_combinations.CombinationSum;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CombinationSumTest {

    @Test
    public void test() {
        int[] input = {2, 3, 6, 7};
        List<List<Integer>> result = CombinationSum.combinationSum(input, 7);
        List<List<Integer>> goldenResult = Arrays.asList(Arrays.asList(2, 2, 3), Arrays.asList(7));
        assertTrue(result.equals(goldenResult));
    }

}
