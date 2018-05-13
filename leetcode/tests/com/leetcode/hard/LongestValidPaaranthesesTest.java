package com.leetcode.hard;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestValidPaaranthesesTest {

	@Test
	public void test() {
		LongestValidPaarantheses l = new LongestValidPaarantheses();
		assertEquals(2, l.longestValidParentheses("(()"));
	}

}
