package epi.strings;

import static org.junit.Assert.*;

import org.junit.Test;

import epi.strings.StringPalidrome;

public class StringPalidromeTest {

	@Test
	public void test() {
		String input = "I Pre fer    P i";
		assertTrue(StringPalidrome.isPalindrome(input));
	}

	@Test
	public void test2() {
		String input = "I f Pre fer    P i";
		assertFalse(StringPalidrome.isPalindrome(input));
	}
	
	@Test
	public void test3() {
		String input = "dog";
		assertFalse(StringPalidrome.isPalindrome(input));
	}
	
	@Test
	public void test4() {
		String input = "dod";
		assertTrue(StringPalidrome.isPalindrome(input));
	}
	
	@Test
	public void test5() {
		String input = "dd";
		assertTrue(StringPalidrome.isPalindrome(input));
	}
}
