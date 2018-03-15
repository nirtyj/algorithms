package com.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leetcode.medium.PalindromicSubstrings;

public class PalindromicSubstringsTest {

	@Test
	public void test() {
		assertEquals(3, PalindromicSubstrings.countSubstrings2("abc"));
		assertEquals(6, PalindromicSubstrings.countSubstrings2("aaa"));
	}

}
