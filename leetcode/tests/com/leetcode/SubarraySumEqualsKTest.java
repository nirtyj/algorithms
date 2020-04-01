package com.leetcode;

import com.leetcode.subarrays.SubarraySumEqualsK;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubarraySumEqualsKTest {

    @Test
    public void test() {
        int[] nums = {1, 2, 1, 2, 1};
        assertEquals(4, SubarraySumEqualsK.subarraySum(nums, 3));
    }

}
