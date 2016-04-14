package epi.searching;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SearchEntryEqualToIndexTest {

	@Test
	public void test() {
		Integer[] input = {-2, 0, 2, 3, 6, 7, 9};
		assertEquals(3, SearchEntryEqualToIndex.searchEntryEqualtoIndex(Arrays.asList(input)));
	}
	
	@Test
	public void test1() {
		Integer[] input = {0, 5, 10, 15};
		assertEquals(0, SearchEntryEqualToIndex.searchEntryEqualtoIndex(Arrays.asList(input)));
	}

	@Test
	public void test2() {
		Integer[] input = {-5, -4, 2, 10, 15, 20};
		assertEquals(2, SearchEntryEqualToIndex.searchEntryEqualtoIndex(Arrays.asList(input)));
	}
	
	@Test
	public void test3() {
		Integer[] input = {-5, -4, 1, 2, 3, 5};
		assertEquals(5, SearchEntryEqualToIndex.searchEntryEqualtoIndex(Arrays.asList(input)));
	}

	@Test
	public void test4() {
		Integer[] input = {-1, 5, 10, 15};
		assertEquals(-1, SearchEntryEqualToIndex.searchEntryEqualtoIndex(Arrays.asList(input)));
	}

}
