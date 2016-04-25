package leetcode.dynamic_programming;

import static org.junit.Assert.*;

import org.junit.Test;

public class BuySellStockTwiceTest {

	@Test
	public void test() {
		int arr[] = {1, 4, 5, 7, 6, 3, 2, 9};
		assertEquals(13, BuySellStockTwice.maxProfit(arr));
	}

}
