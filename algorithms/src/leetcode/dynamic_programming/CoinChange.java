package leetcode.dynamic_programming;

public class CoinChange {

	/**
	 * http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
	 */
	
	public static int coinChange(int[] coins, int sum) 
	{
		if (coins == null || sum == 0)
			return 0;

		int[] result = new int[coins.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = -1;
		}

		for (int i = 0; i < coins.length; i++) {
			if ((sum - coins[i]) >= 0) {
				result[i] = 1 + coinChange(coins, sum - coins[i]);
			}
		}

		int minCoins = Integer.MAX_VALUE;

		for (int i = 0; i < result.length; i++) {
			if (result[i] < minCoins && result[i] != -1)
				minCoins = result[i];
		}

		if (minCoins == Integer.MAX_VALUE)
			return -1;

		return minCoins;
	}
}
