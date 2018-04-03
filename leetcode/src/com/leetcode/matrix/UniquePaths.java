package com.leetcode.matrix;

/**
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
*/
public class UniquePaths {

	/**
	 * Leetcode verified
	 * @param m
	 * @param n
	 * @return
	 */
	public static int uniquePaths(int m, int n) {
		
		if(m == 0 || n == 0)
			return 0;
		
		int[][] dp = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// check for i-1, j-1 out of matrix range.
				if((i-1)>=0 && (j-1)>=0)
				{
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
				}
				else if( (i-1)>=0 && (j -1)<0)
				{
					dp[i][j] = dp[i-1][j];
				}
				else if( (i-1)<0 && (j -1)>=0)
				{
					dp[i][j] =  dp[i][j-1];
				}
				else
				{
					dp[i][j] = 1;
				}
			}
		}
		return dp[m - 1][n - 1];
	}
}
