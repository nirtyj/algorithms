package com.leetcode.medium;

import com.leetcode.subarrays.MinSizeSubarraySum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinSizeSubarraySumTest {

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5};
        MinSizeSubarraySum sum = new MinSizeSubarraySum();
        assertEquals(3, sum.minSubArrayLen(11, nums));
    }

}
