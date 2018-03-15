package com.leetcode.easy;

/**
There is a fence with n posts, each post can be painted with one of the k colors.

You have to paint all the posts such that no more than two adjacent fence posts have the same color.

Return the total number of ways you can paint the fence.
*/
public class PaintFence {

	/**
	 * Leetcode verified
	 * @param n
	 * @param k
	 * @return
	 */
	public int numWays(int n, int k) {
		if (n == 0 || k == 0)
			return 0;
		if (n == 1)
			return k;
		if (n == 2)
			return k * k;

		int[] dp = new int[n];
		dp[0] = k; // first fence k ways
		dp[1] = k * k; // sencond fence k*k ways
		for (int i = 2; i < n; i++) {
			// either i-1 * k-1 ways or i-2 * k-2 ways. sum is asked not minimum - so add.
			dp[i] = dp[i - 1] * (k - 1) + dp[i - 2] * (k - 1);
		}
		return dp[n - 1];
	}
}
