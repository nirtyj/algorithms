package com.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leetcode.medium.SortCharactersByFrequency_451;

public class SortCharactersByFrequencyTest {

	@Test
	public void test() {
		assertEquals("eeeeaaarrd",SortCharactersByFrequency_451.frequencySort("raaeaedere"));
	}

}
