package com.leetcode.matrix;

/**
 * Follow up for "Unique Paths":
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p>
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * <p>
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 */
public class UniquePaths2 {

    /**
     * Leetcode verified
     *
     * @param grid
     * @return
     */
    public static int uniquePathsWithObstacles(int[][] grid) {

        if (grid == null)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }

                // check for i-1, j-1 out of matrix range.
                if ((i - 1) >= 0 && (j - 1) >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else if ((i - 1) >= 0 && (j - 1) < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else if ((i - 1) < 0 && (j - 1) >= 0) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = 1;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
