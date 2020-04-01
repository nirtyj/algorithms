package com.leetcode;

import com.leetcode.dp.HouseRobber;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HouseRobberTest {

    @Test
    public void test() {
        int[] arr = {2, 7, 9, 3, 1};
        assertEquals(12, HouseRobber.rob(arr));
    }

}
