package com.leetcode;

import com.leetcode.subsets_combinations.CombinationSum2;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CombinationSum2Test {

    @Test
    public void test() {
        int[] input = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> result = CombinationSum2.combinationSum(input, 8);
        List<List<Integer>> goldenResult = Arrays.asList(Arrays.asList(1, 2, 5), Arrays.asList(1, 1, 6), Arrays.asList(2, 6), Arrays.asList(1, 7));
        assertTrue(result.equals(goldenResult));
    }

}
