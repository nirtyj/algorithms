package epi.hashtables;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class LongestRangeTest {

	@Test
	public void test() {
		Integer[] entries = { 3, -2, 7, 9, 8, 1, 2, 0, -1, 5, 8 };
		assertEquals(6, LongestRange.findLongestContainedRange(Arrays.asList(entries)));
	}

	@Test
	public void test1() {
		Integer[] entries = { 10, 5, 3, 11, 6, 100, 4 };
		assertEquals(4, LongestRange.findLongestContainedRange(Arrays.asList(entries)));
	}
}
