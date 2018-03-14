package com.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.leetcode.medium.WordBreak;

public class WordBreakTest {

	@Test
	public void test() {
		List<String> dict = new ArrayList<String>();
		dict.add("leet");
		dict.add("code");
		assertEquals(true, WordBreak.wordBreak("leetcode", dict));
	}

}
