package com.leetcode;

import com.leetcode.medium.NextClosestTime;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NextClosestTimeTest {

    @Test
    public void test() {
        NextClosestTime time = new NextClosestTime();
        assertEquals("19:39", time.nextClosestTime("19:34"));
    }

    @Test
    public void test1() {
        NextClosestTime time = new NextClosestTime();
        assertEquals("21:51", time.nextClosestTime("21:45"));
    }
}
