package epi.hashtables;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnagramsTest {

	@Test
	public void test() {
		String word1 = "badcredit";
		String word2 = "debitcard";
		assertTrue(Anagrams.isAnagram(word1, word2));
	}
	
	@Test
	public void test1() {
		String word1 = "badcredit";
		String word2 = "debitcardd";
		assertFalse(Anagrams.isAnagram(word1, word2));
	}
	
	@Test
	public void test2() {
		String word1 = "badcreditb";
		String word2 = "debitcard";
		assertFalse(Anagrams.isAnagram(word1, word2));
	}

}
