package com.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leetcode.easy.ReverseVowelsOfString;

public class ReverseVowelsOfStringTest {

	@Test
	public void test() {
		assertEquals("leotcede", ReverseVowelsOfString.reverseVowels("leetcode"));
	}

}
