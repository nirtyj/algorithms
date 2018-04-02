package com.leetcode.sliding_window;

import java.util.List;

import org.junit.Test;

public class FindAllAnagramsInAStringTest {

	@Test
	public void test() {
		FindAllAnagramsInAString ana = new FindAllAnagramsInAString();
		List<Integer> vals = ana.findAnagrams("cbaebabacd", "abc");
		System.out.println();
	}

}
