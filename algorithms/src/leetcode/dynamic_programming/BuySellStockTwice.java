package leetcode.dynamic_programming;

public class BuySellStockTwice {

	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}

		int[] left = new int[prices.length];
		int[] right = new int[prices.length];

		int low = prices[0];
		left[0] = 0;
		for (int i = 1; i < prices.length; i++) {
			low = Math.min(low, prices[i]);
			// max of previous max profit with current profit
			left[i] = Math.max(left[i - 1], prices[i] - low);
		}

		int high = prices[prices.length - 1];
		right[prices.length - 1] = 0;
		for (int i = prices.length - 2; i >= 0; i--) {
			high = Math.max(high, prices[i]);
			// max of next previous max profit
			right[i] = Math.max(right[i + 1], high - prices[i]);
		}

		int profit = 0;
		for (int i = 0; i < prices.length; i++) {
			profit = Math.max(profit, left[i] + right[i]);
		}

		return profit;
	}
}
