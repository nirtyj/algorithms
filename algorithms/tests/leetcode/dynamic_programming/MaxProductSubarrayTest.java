package leetcode.dynamic_programming;

import static org.junit.Assert.*;

import org.junit.Test;

import com.leetcode.medium.MaxProductSubarray;

public class MaxProductSubarrayTest {

	@Test
	public void test() {
		int arr[] = { 1, -2, -3, 0, 7, -8, -2 };
		assertEquals(112, MaxProductSubarray.maxProduct(arr));
	}

	@Test
	public void test2() {
		int arr[] = { 6, -3, -10, 0, 2 };
		assertEquals(180, MaxProductSubarray.maxProduct(arr));
	}

	@Test
	public void test3() {
		int arr[] = { -1, -3, -10, 0, 60 };
		assertEquals(60, MaxProductSubarray.maxProduct(arr));
	}

	@Test
	public void test4() {
		int arr[] = { -2, -3, 0, -2, -40 };
		assertEquals(80, MaxProductSubarray.maxProduct(arr));
	}

	@Test
	public void test5() {
		int arr[] = { 2, 3, -2, 4 };
		assertEquals(6, MaxProductSubarray.maxProduct(arr));
	}

	@Test
	public void test6() 
	{
		int arr[] = { 3, -1, 4 };
		assertEquals(4, MaxProductSubarray.maxProduct(arr));
	}
	
	@Test
	public void test7() 
	{
		int arr[] = { -2 };
		assertEquals(-2, MaxProductSubarray.maxProduct(arr));
	}


	@Test
	public void test8() 
	{
		int arr[] = { 0, 2 };
		assertEquals(2, MaxProductSubarray.maxProduct(arr));
	}
	
	@Test
	public void test9() 
	{
		int arr[] = { 2,-5,-2,-4,3 };
		assertEquals(24, MaxProductSubarray.maxProduct(arr));
	}

}
