package com.leetcode.medium;

import com.leetcode.matrix.LargestPlusSign;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LargestPlusSignTest {

    @Test
    public void test() {
        LargestPlusSign sign = new LargestPlusSign();
        int[][] mines = {{4, 2}};
        assertEquals(2, sign.orderOfLargestPlusSign(5, mines));
    }

}
