package epi.searching;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class CyclicSortedArrayTest {

	@Test
	public void test() {
		int[] input = {8, 9, 10, 2, 3, 4};
		assertEquals(2, FindMinSortedRotatedArray.findMin(input));
	}

	@Test
	public void test2() {
		int[] input = {9, 10, 2, 3, 4, 8};
		assertEquals(2, FindMinSortedRotatedArray.findMin(input));
	}

	@Test
	public void test3() {
		int[] input = {3, 4, 8, 9, 10, 2};
		assertEquals(2, FindMinSortedRotatedArray.findMin(input));
	}

	@Test
	public void test4() {
		int[] input = {2, 3, 4, 8, 9, 10};
		assertEquals(2, FindMinSortedRotatedArray.findMin(input));
	}
	
	@Test
	public void test5() {
		Integer[] input = {2, 3, 4, 8, 9, 10};
		assertEquals(0, SearchSortedRotatedArray.searchElement(Arrays.asList(input), 2));
	}
	
	@Test
	public void test6() {
		Integer[] input = {2, 3, 4, 8, 9, 10};
		assertEquals(5, SearchSortedRotatedArray.searchElement(Arrays.asList(input), 10));
	}
	
	@Test
	public void test7() {
		Integer[] input = {2, 3, 4, 8, 9, 10};
		assertEquals(3, SearchSortedRotatedArray.searchElement(Arrays.asList(input), 8));
	}
	
	@Test
	public void test8() {
		Integer[] input = {8, 9, 10, 2, 3, 4};
		assertEquals(0, SearchSortedRotatedArray.searchElement(Arrays.asList(input), 8));
	}
	
	@Test
	public void test9() {
		Integer[] input = {8, 9, 10, 2, 3, 4};
		assertEquals(3, SearchSortedRotatedArray.searchElement(Arrays.asList(input), 2));
	}
	
	@Test
	public void test10() {
		Integer[] input = {8, 9, 10, 2, 3, 4};
		assertEquals(4, SearchSortedRotatedArray.searchElement(Arrays.asList(input), 3));
	}
	
	@Test
	public void test11() {
		Integer[] input = { 3, 4, 8, 9, 10, 2,};
		assertEquals(5, SearchSortedRotatedArray.searchElement(Arrays.asList(input), 2));
	}
	
	@Test
	public void test12() {
		Integer[] input = { 9, 10, 2, 3, 4, 8,};
		assertEquals(1, SearchSortedRotatedArray.searchElement(Arrays.asList(input), 10));
	}
	
	@Test
	public void test13() {
		Integer[] input = { 9, 10, 2, 3, 4, 8,};
		assertEquals(0, SearchSortedRotatedArray.searchElement(Arrays.asList(input), 9));
	}
}
