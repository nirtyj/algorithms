package epi.searching;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class CyclicSortedArrayTest {

	@Test
	public void test() {
		Integer[] input = {8, 9, 10, 2, 3, 4};
		assertEquals(3, CyclicSortedArray.findPivot(Arrays.asList(input)));
	}

	@Test
	public void test2() {
		Integer[] input = {9, 10, 2, 3, 4, 8};
		assertEquals(2, CyclicSortedArray.findPivot(Arrays.asList(input)));
	}

	@Test
	public void test3() {
		Integer[] input = {3, 4, 8, 9, 10, 2};
		assertEquals(5, CyclicSortedArray.findPivot(Arrays.asList(input)));
	}

	@Test
	public void test4() {
		Integer[] input = {2, 3, 4, 8, 9, 10};
		assertEquals(0, CyclicSortedArray.findPivot(Arrays.asList(input)));
	}	
}
