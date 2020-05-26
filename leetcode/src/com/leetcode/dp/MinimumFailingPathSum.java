package com.leetcode.dp;

/**
 * Given a square array of integers A, we want the minimum sum of a falling path through A.
 *
 * A falling path starts at any element in the first row, and chooses one element from each row.  The next row's choice must be in a column that is different from the previous row's column by at most one.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: 12
 * Explanation:
 * The possible falling paths are:
 * [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
 * [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
 * [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
 * The falling path with the smallest sum is [1,4,7], so the answer is 12.
 *
 *
 *
 * Note:
 *
 * 1 <= A.length == A[0].length <= 100
 * -100 <= A[i][j] <= 100
 */
public class MinimumFailingPathSum {

    /**
     * 4 ms O(m*n) - size of grid
     * @param grid
     * @return
     */
    public int minFallingPathSum(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        // if length is 1, just find the min
        if (grid.length == 1) {
            for(int i=0;i<grid.length;i++){
                min = Math.min(min, grid[0][i]);
            }
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        // copy the first row to the DP matrix
        for(int i=0;i<grid.length;i++){
            dp[0][i] = grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int top = (i-1) < 0 ? Integer.MAX_VALUE : dp[i-1][j];
                int topLeft = (i-1) < 0 || (j-1) < 0 ? Integer.MAX_VALUE : dp[i-1][j-1];
                int topRight = (i-1) < 0 || (j+1) >= n ? Integer.MAX_VALUE : dp [i-1][j+1];
                dp[i][j] = grid[i][j] + Math.min(top, Math.min(topLeft, topRight));
                if (i == m -1) { // last row
                    min = Math.min(min, dp[i][j]);
                }
            }
        }
        return min;
    }
}
