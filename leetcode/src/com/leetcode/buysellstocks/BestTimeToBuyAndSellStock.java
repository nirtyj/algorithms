package com.leetcode.buysellstocks;

/**
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.
*/
public class BestTimeToBuyAndSellStock {

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
}
