package leetcode.medium;

import static org.junit.Assert.*;

import org.junit.Test;

import leetcode.sliding_window.LongestSubstringWithoutRepeatingCharacters;

public class LongestSubstringWithoutRepeatingCharsTest {

	@Test
	public void test() {
		String st = "abcabcbb";
		assertEquals(3, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(st));
	}

}
