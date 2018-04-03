package com.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leetcode.sliding_window.LongestSubstringWithoutRepeatingCharacters;

public class LongestSubstringWithoutRepeatingCharsTest {

	@Test
	public void test() {
		LongestSubstringWithoutRepeatingCharacters s = new LongestSubstringWithoutRepeatingCharacters();
		String st = "abcabcbb";
		assertEquals(3, s.lengthOfLongestSubstring(st));
	}

}
