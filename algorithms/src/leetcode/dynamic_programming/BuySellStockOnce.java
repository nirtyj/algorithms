package leetcode.dynamic_programming;

public class BuySellStockOnce {

	/**
	 *  buy and sell stock once
	 */
	public static int buySellOnce(int arr[])
	{
		int low = arr[0];
		int maxProfit = 0;
		for(int i=1;i<arr.length;i++)
		{
			maxProfit = Math.max(maxProfit, arr[i] - low);
			low = Math.min(low, arr[i]);
		}
		return maxProfit;
	}
}
