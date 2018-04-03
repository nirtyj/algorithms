package com.leetcode.matrix;

/**
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
*/
public class LongestIncreasingMatrixPath {

	public final static int[][] DIRECTIONS = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length <= 0)
			return 0;

		int[][] dp = new int[matrix.length][matrix[0].length];

		int maxVal = 1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				maxVal = Math.max(maxVal, dfsHelper(matrix, i, j, dp));
			}
		}

		return maxVal;
	}

	private static int dfsHelper(int[][] matrix, int i, int j, int[][] dp) {

		if (dp[i][j] != 0)
			return dp[i][j];

		if (!isWithinMatrixBounday(matrix, i, j))
			return 0;

		// mark seen
		int temp = matrix[i][j];
		matrix[i][j] = Integer.MIN_VALUE;

		int maxVal = 1;

		for (int[] direction : DIRECTIONS) {

			int newx = i + direction[0];
			int newy = j + direction[1];
			if (isValidij(matrix, newx, newy, temp)) {

				if (dp[newx][newy] > 0) {
					maxVal = Math.max(maxVal, 1 + dp[newx][newy]);
				} else {
					int val = dfsHelper(matrix, newx, newy, dp);
					maxVal = Math.max(maxVal, 1 + val);
				}
			}
		}

		// revert back to old val
		matrix[i][j] = temp;
		dp[i][j] = maxVal;
		return maxVal;
	}

	private static boolean isValidij(int[][] matrix, int x, int y, int prev) {
		if (isWithinMatrixBounday(matrix, x, y) && matrix[x][y] > prev)
			return true;
		return false;
	}

	private static boolean isWithinMatrixBounday(int[][] matrix, int x, int y) {
		return (x >= 0 && x < matrix.length) && (y >= 0 && y < matrix[0].length);
	}
}
