package com.leetcode;

import com.leetcode.hard.TrappingRainWater_42;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrappingRainWaterTest {

    @Test
    public void test() {
        int[] input = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        assertEquals(6, TrappingRainWater_42.trap(input));
    }

}
