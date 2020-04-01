package com.leetcode;

import com.leetcode.subarrays.ContinuousSubarraySum;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class ContinuousSubarraySumTest {

    @Test
    public void test() {
        int[] nums = {0, 1, 0};
        assertFalse(ContinuousSubarraySum.checkSubarraySum(nums, 0));
    }

}
