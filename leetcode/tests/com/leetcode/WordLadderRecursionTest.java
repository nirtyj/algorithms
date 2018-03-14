package com.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.leetcode.hard.WordLadderII;
import com.leetcode.utils.LeetcodeUtils;

public class WordLadderRecursionTest {

	@Test
	public void test() {
		String[] dictArr = { "hot", "dot", "dog", "lot", "log", "cog" };
		List<String> dict = LeetcodeUtils.arrayToList(dictArr);
		assertEquals(5, WordLadderII.findLadders("hit", "cog", dict).get(0).size());
	}

	@Test
	public void test2() {
		String[] dictArr = { "hot", "dot", "dog", "lot", "log" };
		List<String> dict = LeetcodeUtils.arrayToList(dictArr);
		assertEquals(0, WordLadderII.findLadders("hit", "cog", dict).size());
	}
	
	@Test
	public void test3() {
		String[] dictArr = { "hot", "dog" };
		List<String> dict = LeetcodeUtils.arrayToList(dictArr);
		assertEquals(0, WordLadderII.findLadders("hot", "dog", dict).size());
	}
	

	@Test
	public void test4() {
		String[] dictArr = { "hot", "dog", "dot"};
		List<String> dict = LeetcodeUtils.arrayToList(dictArr);
		assertEquals(3, WordLadderII.findLadders("hot", "dog", dict).get(0).size());
	}
	
	@Test
	public void test5() {
		String[] dictArr = { "hot", "dot", "dog"};
		List<String> dict = LeetcodeUtils.arrayToList(dictArr);
		assertEquals(2, WordLadderII.findLadders("hot", "dot", dict).get(0).size());
	}
	
	@Test
	public void test7() {
		String[] dictArr = { "hot", "dog", "dot" };
		List<String> dict = LeetcodeUtils.arrayToList(dictArr);
		assertEquals(3, WordLadderII.findLadders("hot", "dog", dict).get(0).size());
	}

	@Test
	public void test6() {
		String[] dictArr = { "si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av",
				"sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe",
				"ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if",
				"pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi",
				"os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt",
				"io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye" };

		List<String> dict = LeetcodeUtils.arrayToList(dictArr);
		assertEquals(51, WordLadderII.findLadders("qa", "sq", dict).size());
	}
}
