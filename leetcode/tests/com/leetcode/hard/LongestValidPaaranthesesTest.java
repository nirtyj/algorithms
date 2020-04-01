package com.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestValidPaaranthesesTest {

    @Test
    public void test() {
        LongestValidPaarantheses l = new LongestValidPaarantheses();
        assertEquals(2, l.longestValidParentheses("(()"));
    }

}
