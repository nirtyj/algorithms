package sorting;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class BubbleSortTest {

	@Test
	public void test() {
		Integer[] arr1 = { 1, 12, 5, 26, 7, 14, 3, 7, 2 };
		Integer[] resultArray = { 1, 2, 3, 5, 7, 7, 12, 14, 26 };
		BubbleSort.sort(arr1);
		assertTrue(Arrays.asList(arr1).equals(Arrays.asList(resultArray)));
	}

	@Test
	public void test2() {
		Integer[] arr1 = { 9, 28, 1, 12, 5, 26, 7, 14, 3, 7, 2 };
		Integer[] resultArray = { 1, 2, 3, 5, 7, 7, 9, 12, 14, 26, 28};
		BubbleSort.sort(arr1);
		assertTrue(Arrays.asList(arr1).equals(Arrays.asList(resultArray)));
	}
	
	@Test
	public void test3() {
		Integer[] arr1 = { -3, -9, -2, -1 };
		Integer[] resultArray = { -9, -3, -2, -1};
		BubbleSort.sort(arr1);
		assertTrue(Arrays.asList(arr1).equals(Arrays.asList(resultArray)));
	}
	
	@Test
	public void test4() {
		Integer[] arr1 = { 1, 12, 5, 26, 7, 14, 3, 7, 2 };
		Integer[] resultArray = { 1, 2, 3, 5, 7, 7, 12, 14, 26 };
		BubbleSort.sortSlow(arr1);
		assertTrue(Arrays.asList(arr1).equals(Arrays.asList(resultArray)));
	}

	@Test
	public void test5() {
		Integer[] arr1 = { 9, 28, 1, 12, 5, 26, 7, 14, 3, 7, 2 };
		Integer[] resultArray = { 1, 2, 3, 5, 7, 7, 9, 12, 14, 26, 28};
		BubbleSort.sortSlow(arr1);
		assertTrue(Arrays.asList(arr1).equals(Arrays.asList(resultArray)));
	}
	
	@Test
	public void test6() {
		Integer[] arr1 = { -3, -9, -2, -1 };
		Integer[] resultArray = { -9, -3, -2, -1};
		BubbleSort.sortSlow(arr1);
		assertTrue(Arrays.asList(arr1).equals(Arrays.asList(resultArray)));
	}
	

}
