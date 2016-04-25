package leetcode.dynamic_programming;

import static org.junit.Assert.*;

import org.junit.Test;

import leetcode.dynamic_programming.LongestPalindromicSubstring;

public class LongestPalindromicSubstringTest {

	@Test
	public void test() {
		assertEquals("geeksskeeg", LongestPalindromicSubstring.longestPalindrome2("forgeeksskeegfor"));
		assertEquals("aba", LongestPalindromicSubstring.longestPalindrome2("abacdfgdcaba"));
		assertEquals("anana", LongestPalindromicSubstring.longestPalindrome2("bananas"));
	}
	
	@Test
	public void test2() {
		assertEquals("geeksskeeg", LongestPalindromicSubstring.longestPalindrome2("forgeeksskeegfor"));
		assertEquals("aba", LongestPalindromicSubstring.longestPalindrome2("abacdfgdcaba"));
		assertEquals("anana", LongestPalindromicSubstring.longestPalindrome2("bananas"));
	}

}
