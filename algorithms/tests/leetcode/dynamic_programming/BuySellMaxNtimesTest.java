package leetcode.dynamic_programming;

import static org.junit.Assert.*;

import org.junit.Test;

public class BuySellMaxNtimesTest {

	@Test
	public void test() {
		int arr[] = {5, 1, 2, 3, 4};
		assertEquals(3, BuySellMaxNtimes.maxProfit(arr));
	}

	@Test
	public void test1() {
		int arr[] = {2, 4, 2, 3, 9};
		assertEquals(9, BuySellMaxNtimes.maxProfit(arr));
	}

	@Test
	public void test2() {
		int arr[] = {1, 2, 0, 3, 9};
		assertEquals(10, BuySellMaxNtimes.maxProfit(arr));
	}

}
