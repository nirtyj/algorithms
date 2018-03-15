package com.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leetcode.medium.SortCharactersByFrequency;

public class SortCharactersByFrequencyTest {

	@Test
	public void test() {
		assertEquals("eeeeaaarrd",SortCharactersByFrequency.frequencySort("raaeaedere"));
	}

}
