package epi.strings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class ReverseWordsInSentenceTest {

	@Test
	public void testReverseWords() {
		char[] input = "Alice like Bob".toCharArray();
		ReverseWordsInSentence.reverseWords(input);
		assertTrue(Arrays.equals("Bob like Alice".toCharArray(), input));
	}

	@Test
	public void testReverseWords2() {
		char[] input = "Alice     like a Bob".toCharArray();
		ReverseWordsInSentence.reverseWords(input);
		assertTrue(Arrays.equals("Bob a like     Alice".toCharArray(), input));
	}

	@Test
	public void testReverseWords1() {
		Random gen = new Random();
		for (int times = 0; times < 1000; ++times) {
			String str = randString(gen.nextInt(10000));
			char[] input = str.toCharArray();
			ReverseWordsInSentence.reverseWords(input);
			ReverseWordsInSentence.reverseWords(input);
			assertTrue(Arrays.equals(str.toCharArray(), input));

		}
	}

	static String randString(int len) {
		Random gen = new Random();
		StringBuilder ret = new StringBuilder();
		while (len-- > 0) {
			ret.append((char) (gen.nextInt(4) + 97));
		}
		return ret.toString();
	}

	@Test
	public void testReverseWordsWithLinkedLists() {
		String input = "Alice like Bob";
		assertEquals("Bob like Alice", ReverseWordsInSentence.reverseWordsWithLinkedList(input));
	}

	@Test
	public void testReverseWords1Withlinkedlist() {
		Random gen = new Random();
		for (int times = 0; times < 1000; ++times) {
			String str = randString(gen.nextInt(10000));
			String reversed = ReverseWordsInSentence.reverseWordsWithLinkedList(str);
			checkAnswer(str, reversed);
		}
	}

	private static void checkAnswer(String ori, String str) {
		String reversed = ReverseWordsInSentence.reverseWordsWithLinkedList(str);
		assertTrue(ori.equals(reversed));
	}

	@Test
	public void testReverseWords2WithLinkedList() {
		String input = "Alice     like a Bob";
		assertEquals("Bob a like     Alice", ReverseWordsInSentence.reverseWordsWithLinkedList(input));
	}
	

	@Test
	public void testReverseWordsWithStack() {
		String input = "Alice like Bob";
		assertEquals("Bob like Alice", ReverseWordsInSentence.reverseWordsWithStack(input));
	}
	
	@Test
	public void testReverseWords2WithStack() {
		String input = "Alice     like a Bob";
		assertEquals("Bob a like     Alice", ReverseWordsInSentence.reverseWordsWithStack(input));
	}
}
