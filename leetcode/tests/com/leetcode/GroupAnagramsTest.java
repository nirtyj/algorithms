package com.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.leetcode.medium.GroupAnagrams;

public class GroupAnagramsTest {

	@Test
	public void test() {
		String[] input = {"eat","tea","tan","ate","nat","bat"};
		List<List<String>> result =GroupAnagrams.groupAnagrams(input);
		assertEquals(3, result.size());
	}

}
