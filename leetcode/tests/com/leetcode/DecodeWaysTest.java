package com.leetcode;

import com.leetcode.dp.DecodeWays;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DecodeWaysTest {

    @Test
    public void test() {
        DecodeWays ways = new DecodeWays();
        assertEquals(2, ways.numDecodings("11"));
    }

}
