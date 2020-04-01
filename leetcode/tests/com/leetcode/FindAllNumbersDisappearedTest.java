package com.leetcode;

import com.leetcode.easy.FindAllNumbersDisappeared;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FindAllNumbersDisappearedTest {

    @Test
    public void test() {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = FindAllNumbersDisappeared.findDisappearedNumbers(arr);
        assertEquals(2, result.size());
    }

}
