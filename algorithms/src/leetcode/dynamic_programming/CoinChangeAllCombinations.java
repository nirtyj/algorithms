package leetcode.dynamic_programming;

public class CoinChangeAllCombinations {

	public static int coinChange(int[] coins, int sum) {
		if (sum == 0)
			return 0;

		return coinChangeHelper(0, coins, sum);
	}

	private static int coinChangeHelper(int i, int[] coins, int remainingSum) {
		if (remainingSum < 0 || i >= coins.length) {
			return 0;
		}

		if (remainingSum == 0) {
			return 1;
		}
		return coinChangeHelper(i, coins, remainingSum - coins[i]) + coinChangeHelper(i + 1, coins, remainingSum);
	}

	public static int coinChangeDp(int[] coins, int sum) {

		if (sum == 0)
			return 0;

		int[][] matrix = new int[coins.length + 1][sum + 1];

		// if amount=0 then just return empty set to make the change
		for (int i = 0; i <= coins.length; i++) {
			matrix[i][0] = 1;
		}

		// if no coins given, 0 ways to change the amount
		for (int i = 1; i <= sum; i++) {
			matrix[0][i] = 0;
		}

		// now fill rest of the matrix.
		for (int i = 1; i <= coins.length; i++) {
			for (int amt = 1; amt <= sum; amt++) {
				// check if the coin value is less than the amount needed
				if (coins[i - 1] <= amt) {
					// reduce the amount by coin value and
					// use the subproblem solution (amount-v[i]) and
					// add the solution from the top to it
					
					// sum of don't include current coin val + what's if you include current coin.
					//    top val                            + same [row]  [sum - coin val]
					matrix[i][amt] = matrix[i - 1][amt] + matrix[i][amt - coins[i - 1]];
				} else {
					// just copy the value from the top
					// dont include current coin val
					matrix[i][amt] = matrix[i - 1][amt];
				}
			}
		}
		return matrix[coins.length][sum];
	}
}
