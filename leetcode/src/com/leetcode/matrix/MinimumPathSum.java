package com.leetcode.matrix;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Example 1:
 * [[1,3,1],
 * [1,5,1],
 * [4,2,1]]
 * Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum {

    /**
     * Leetcode verified
     *
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {

        if (grid == null)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // check for i-1, j-1 out of matrix range.
                if ((i - 1) >= 0 && (j - 1) >= 0) {   // majority cases, min of from top to bottom or left to right with sum
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                } else if ((i - 1) >= 0 && (j - 1) < 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else if ((i - 1) < 0 && (j - 1) >= 0) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];

    }
}
