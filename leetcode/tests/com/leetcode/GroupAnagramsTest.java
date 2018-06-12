package com.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.leetcode.medium.GroupAnagrams_49;

public class GroupAnagramsTest {

	@Test
	public void test() {
		String[] input = {"eat","tea","tan","ate","nat","bat"};
		List<List<String>> result =GroupAnagrams_49.groupAnagrams(input);
		assertEquals(3, result.size());
	}

}
