package leetcode.dynamic_programming;

import static org.junit.Assert.*;

import org.junit.Test;

import leetcode.dynamic_programming.LongestPalindromicSubstring;

public class LongestPalindromicSubstringTest {

	@Test
	public void test() {
		assertEquals("geeksskeeg", LongestPalindromicSubstring.longestPalindrome2("forgeeksskeegfor"));
		assertEquals("abacd", LongestPalindromicSubstring.longestPalindrome2("abacdfgdcaba"));
		
	}

}
