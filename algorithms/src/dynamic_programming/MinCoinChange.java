package dynamic_programming;

public class MinCoinChange {


	/**
	 * min number of coins necessary to form the target sum
	 * @param coins
	 * @param sum
	 * @return
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
	
	public static int coinChangeDp(int[] coins, int sum) 
	{
		if (coins == null || sum == 0)
			return 0;

		int[] minCoinsArray = new int [sum+1];
		
		// holds min change for 1 upto sum.
		minCoinsArray[0] = 0;
		
		// for each sum calculate how many coins.
		for( int j = 1; j <= sum ; j++)
		{
			
			int[] result = new int[coins.length];
			for (int i = 0; i < result.length; i++) {
				result[i] = -1;
			}

			for (int i = 0; i < coins.length; i++) {
				if ((j - coins[i]) >= 0) {
					result[i] = 1 + minCoinsArray[j - coins[i]];
				}
			}

			int minCoins = Integer.MAX_VALUE;

			for (int i = 0; i < result.length; i++) {
				if (result[i] < minCoins && result[i] != -1)
					minCoins = result[i];
			}

			if (minCoins == Integer.MAX_VALUE)
				minCoinsArray[j] = -1;
			else
				minCoinsArray[j] = minCoins;
		}
		

		return minCoinsArray[sum];
	}
}
