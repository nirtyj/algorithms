package com.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leetcode.easy.RomanToInteger;

public class RomanToIntegerTest {

	@Test
	public void test() {
		assertEquals(3787, RomanToInteger.romanToInt("MMMDCCLXXXvII"));
		assertEquals(374, RomanToInteger.romanToInt("CCCLXXIV"));
		assertEquals(44, RomanToInteger.romanToInt("XLIV"));
	}

}
