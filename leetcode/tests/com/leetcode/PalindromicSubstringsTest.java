package com.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leetcode.medium.PalindromicSubstrings_647;

public class PalindromicSubstringsTest {

	@Test
	public void test() {
		assertEquals(3, PalindromicSubstrings_647.countSubstrings2("abc"));
		assertEquals(6, PalindromicSubstrings_647.countSubstrings2("aaa"));
	}

}
