package leetcode.medium;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharsTest {

	@Test
	public void test() {
		String st = "abcabcbb";
		assertEquals(3, LongestSubstringWithoutRepeatingChars.lengthOfLongestSubstring(st));
	}

}
