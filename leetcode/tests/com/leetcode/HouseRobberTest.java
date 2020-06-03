package com.leetcode;

import com.leetcode.dp.fibonacci.HouseRobber_LC198;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HouseRobberTest {

    @Test
    public void test() {
        int[] arr = {2, 7, 9, 3, 1};
        assertEquals(12, HouseRobber_LC198.rob(arr));
    }

}
