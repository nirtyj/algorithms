package com.leetcode.dp;

/**
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner
 * (row1, col1) and lower right corner (row2, col2).
 *
 * Range Sum Query 2D
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
 *
 * Example:
 * Given matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 */
public class RangeSumQuery2D_LC304 {
    int[][] dp;

    /**
     * O(n) DP
     * @param matrix
     */
    public RangeSumQuery2D_LC304(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            dp = null;
            return;
        }
        dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                int top = 0;
                if (i - 1 >= 0) {
                    top = dp[i - 1][j];
                }
                dp[i][j] = matrix[i][j] + rowSum + top;
                rowSum = rowSum + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (dp == null) {
            return 0;
        }
        int[][] stop = dp;
        int leftBoundary = 0;
        if (col1 - 1 >= 0) {
            leftBoundary = dp[row2][col1 - 1];
        }
        int rightBoundary = 0;
        if (row1 - 1 >= 0) {
            rightBoundary = dp[row1 - 1][col2];
        }
        int top = 0;
        if (row1 - 1 >= 0 && col1 - 1 >= 0) {
            top = dp[row1 - 1][col1 - 1];
        }
        return dp[row2][col2] - leftBoundary - rightBoundary + top;
    }
}
