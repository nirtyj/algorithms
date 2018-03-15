package com.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leetcode.sliding_window.LongestSubstringWithoutRepeatingCharacters;

public class LongestSubstringWithoutRepeatingCharsTest {

	@Test
	public void test() {
		String st = "abcabcbb";
		assertEquals(3, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(st));
	}

}
