package epi.hashtables;

import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromeTest {

	@Test
	public void test() {
		assertTrue(Palindrome.canFormPalindrome("level"));
		assertTrue(Palindrome.canFormPalindrome("rotator"));
		assertTrue(Palindrome.canFormPalindrome("foobaraboof"));
		assertTrue(Palindrome.canFormPalindrome("edified"));
		assertTrue(Palindrome.canFormPalindrome("E   di   f Ied"));
		assertTrue(Palindrome.canFormPalindrome("aaaassl"));
	}
	

	@Test
	public void test2() {
		assertFalse(Palindrome.canFormPalindrome("dog"));
		assertFalse(Palindrome.canFormPalindrome("ac"));
		assertFalse(Palindrome.canFormPalindrome("aaaasskl"));
	}

}
