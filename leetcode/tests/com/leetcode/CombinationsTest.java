package com.leetcode;

import com.leetcode.subsets_combinations.Combinations;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CombinationsTest {

    @Test
    public void test() {
        List<List<Integer>> result = Combinations.combine(4, 2);
        List<List<Integer>> goldenResult = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(1, 3), Arrays.asList(1, 4),
                Arrays.asList(2, 3), Arrays.asList(2, 4), Arrays.asList(3, 4));
        assertTrue(result.equals(goldenResult));
    }
}
