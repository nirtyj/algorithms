package leetcode.dynamic_programming;

public class BuySellMaxNtimes {

	public static int maxProfit(int[] prices) {
		int totalProfit = 0;

		for (int i = 1; i < prices.length; i++) {
			int profit = prices[i] - prices[i - 1];
			if (profit > 0)
				totalProfit = totalProfit + profit;
		}
		return totalProfit;
	}

}
