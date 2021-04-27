package com.leetcode.medium;

import com.leetcode.sliding_window.MinSizeSubarraySum_LC209;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinSizeSubarraySumTest {

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5};
        MinSizeSubarraySum_LC209 sum = new MinSizeSubarraySum_LC209();
        assertEquals(3, sum.minSubArrayLen(11, nums));
    }

}
