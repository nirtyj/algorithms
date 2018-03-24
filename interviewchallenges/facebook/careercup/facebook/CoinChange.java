package careercup.facebook;

/**
 * Find out how many ways you can make change of N cents given coins of values
 * [a1, a2, a3...], each type of coin got infinite supplies. Arrangement of
 * coins don't matter.
 */
public class CoinChange {
	
	/**
	 * 
	 * @param amount
	 * @param coins
	 * @return
	 */
	public int change(int amount, int[] coins) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		for (int coin : coins) {
			for (int i = 1; i <= amount; i++) {
				if (i >= coin)
					dp[i] += dp[i - coin];
			}
		}
		return dp[amount];
	}
}
