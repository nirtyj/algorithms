package com.leetcode.hard;

import static org.junit.Assert.*;

import org.junit.Test;

public class LengthOfLongestConsecutiveSequenceTest {

	@Test
	public void test() {
		LengthOfLongestConsecutiveSequence l = new LengthOfLongestConsecutiveSequence();
		assertEquals(4, l.longestConsecutive(new int[] { 100, 1, 3, 2, 4, 200 }));
	}

	@Test
	public void test2() {
		LengthOfLongestConsecutiveSequence l = new LengthOfLongestConsecutiveSequence();
		assertEquals(3,
				l.longestConsecutive(new int[] { 2147483646, -2147483647, 0, 2, 2147483644, -2147483645, 2147483645 }));
	}
}
