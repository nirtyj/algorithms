package com.leetcode;

import com.leetcode.hard.LargestRectangleInHistogram;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LargestHistogramRectangleTest {

    @Test
    public void test() {
        int[] input = {2, 1, 5, 6, 2, 3};
        assertEquals(10, LargestRectangleInHistogram.largestRectangleArea(input));
    }

}
