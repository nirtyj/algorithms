package leetcode.dynamic_programming;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import leetcode.buysellstocks.BestTimeToBuyAndSellStock;

public class BuySellStockOnceTest {

	@Test
	public void test() {
		int arr[] = {310, 315, 270, 295, 260, 270, 290, 230, 255, 250};
		assertEquals(30, BestTimeToBuyAndSellStock.buySellOnce(arr));
	}

}
