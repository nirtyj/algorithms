package epi.sorting;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import epi.sorting.MergeTwoSortedArrays;

public class MergeTwoSortedArraysTest {

	@Test
	public void test() {
		Integer[] arr1 = { 5, 6, 8, 10, 0, 0, 0 };
		Integer[] arr2 = { 2, 7, 11 };

		MergeTwoSortedArrays merge = new MergeTwoSortedArrays();
		merge.mergeSortedArrays2(Arrays.asList(arr1), 4, Arrays.asList(arr2), 3);

		Integer[] resultArray = { 2, 5, 6, 7, 8, 10, 11 };
		assertEquals(Arrays.asList(resultArray), Arrays.asList(arr1));
	}
	
	@Test
	public void test2() {
		Integer[] arr1 = { 5, 6, 8, 10, 0, 0, 0 };
		Integer[] arr2 = { 6, 8, 9 };

		MergeTwoSortedArrays merge = new MergeTwoSortedArrays();
		merge.mergeSortedArrays2(Arrays.asList(arr1), 4, Arrays.asList(arr2), 3);

		Integer[] resultArray = { 5, 6, 6, 8, 8, 9, 10 };
		assertEquals(Arrays.asList(resultArray), Arrays.asList(arr1));
	}

}
