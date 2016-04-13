package epi.sorting;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import epi.sorting.IntersectTwoSortedArrays;

public class IntersectTwoSortedArraysTest {

	@Test
	public void test() {
		Integer[] arr1 = {2,3,4,5};
		Integer[] arr2 = {2,3,5};
		
		IntersectTwoSortedArrays sortArr = new IntersectTwoSortedArrays();
		List<Integer> result = sortArr.intersectTwoSortedArrays1(Arrays.asList(arr1), Arrays.asList(arr2));
		Integer[] resultArray = {2, 3, 5};
		assertTrue(result.equals(Arrays.asList(resultArray)));
	}
	
	@Test
	public void test2() {
		Integer[] arr1 = {2,3,4,5};
		Integer[] arr2 = {2,3,5};
		
		IntersectTwoSortedArrays sortArr = new IntersectTwoSortedArrays();
		List<Integer> result = sortArr.intersectTwoSortedArrays2(Arrays.asList(arr1), Arrays.asList(arr2));
		Integer[] resultArray = {2, 3, 5};
		assertTrue(result.equals(Arrays.asList(resultArray)));
	}

}
