package leetcode.dynamic_programming;

public class BuySellStockOnce {

	/**
	 * buy and sell stock once
	 */
	public static int buySellOnce(int arr[]) {
		int low = arr[0];
		int maxProfit = 0;
		for (int i = 1; i < arr.length; i++) {
			maxProfit = Math.max(maxProfit, arr[i] - low);
			low = Math.min(low, arr[i]);
		}
		return maxProfit;
	}

	/**
	 * Leetcode verified
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;
		int maxProfit = 0;
		int buyIndex = 0;
		int sellIndex = 1;
		while (sellIndex < prices.length) {
			if (prices[sellIndex] < prices[buyIndex]) {
				buyIndex = sellIndex;
				sellIndex++;
			} else {
				maxProfit = Math.max(maxProfit, prices[sellIndex] - prices[buyIndex]);
				sellIndex++;
			}
		}
		return maxProfit;
	}
}
