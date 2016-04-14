package epi.searching;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class BinarySearchTest {

	@Test
	public void test() {
		Integer[] input = {2, 3, 5, 7, 9, 11, 13, 17 ,19};
		assertEquals(3, BinarySearch.search(Arrays.asList(input), 7));
	}
	
	@Test
	public void test2() {
		Integer[] input = {2, 3, 5, 7, 9, 11, 13, 17 ,19};
		assertEquals(0, BinarySearch.search(Arrays.asList(input), 2));
	}
	
	@Test
	public void test3() {
		Integer[] input = {2, 3, 5, 7, 9, 11, 13, 17 ,19};
		assertEquals(8, BinarySearch.search(Arrays.asList(input), 19));
	}
	
	@Test
	public void test4() {
		Integer[] input = {2, 3, 5, 7, 9, 11, 13, 17 ,19};
		assertEquals(-1, BinarySearch.search(Arrays.asList(input), 6));
	}
	
	@Test
	public void test5() {
		Integer[] input = {2, 3, 5, 7, 9, 11, 13, 17 ,19};
		assertEquals(5, BinarySearch.search(Arrays.asList(input), 11));
	}

	@Test
	public void testr() {
		Integer[] input = {2, 3, 5, 7, 9, 11, 13, 17 ,19};
		assertEquals(3, BinarySearch.searchRecurse(Arrays.asList(input), 7, 0 ,8));
	}
	
	@Test
	public void test2r() {
		Integer[] input = {2, 3, 5, 7, 9, 11, 13, 17 ,19};
		assertEquals(0, BinarySearch.searchRecurse(Arrays.asList(input), 2, 0 ,8));
	}
	
	@Test
	public void test3r() {
		Integer[] input = {2, 3, 5, 7, 9, 11, 13, 17 ,19};
		assertEquals(8, BinarySearch.searchRecurse(Arrays.asList(input), 19, 0 ,8));
	}
	
	@Test
	public void test4r() {
		Integer[] input = {2, 3, 5, 7, 9, 11, 13, 17 ,19};
		assertEquals(-1, BinarySearch.searchRecurse(Arrays.asList(input), 6, 0 ,8));
	}
	
	@Test
	public void test5r() {
		Integer[] input = {2, 3, 5, 7, 9, 11, 13, 17 ,19};
		assertEquals(5, BinarySearch.search(Arrays.asList(input), 11));
	}

}
