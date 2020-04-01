package com.leetcode.matrix;

import java.util.Arrays;

/**
 * In a 2D grid from (0, 0) to (N-1, N-1), every cell contains a 1, except those cells in the given list mines which are 0. What is the largest axis-aligned plus sign of 1s contained in the grid? Return the order of the plus sign. If there is none, return 0.
 * <p>
 * An "axis-aligned plus sign of 1s of order k" has some center grid[x][y] = 1 along with 4 arms of length k-1 going up, down, left, and right, and made of 1s. This is demonstrated in the diagrams below. Note that there could be 0s or 1s beyond the arms of the plus sign, only the relevant area of the plus sign is checked for 1s.
 * <p>
 * Examples of Axis-Aligned Plus Signs of Order k:
 * <p>
 * Order 1:
 * 000
 * 010
 * 000
 * <p>
 * Order 2:
 * 00000
 * 00100
 * 01110
 * 00100
 * 00000
 * <p>
 * Order 3:
 * 0000000
 * 0001000
 * 0001000
 * 0111110
 * 0001000
 * 0001000
 * 0000000
 * Example 1:
 * <p>
 * Input: N = 5, mines = [[4, 2]]
 * Output: 2
 * Explanation:
 * 11111
 * 11111
 * 11111
 * 11111
 * 11011
 * In the above grid, the largest plus sign can only be order 2.  One of them is marked in bold.
 * Example 2:
 * <p>
 * Input: N = 2, mines = []
 * Output: 1
 * Explanation:
 * There is no plus sign of order 2, but there is of order 1.
 * Example 3:
 * <p>
 * Input: N = 1, mines = [[0, 0]]
 * Output: 0
 * Explanation:
 * There is no plus sign, so return 0.
 * Note:
 * <p>
 * N will be an integer in the range [1, 500].
 * mines will have length at most 5000.
 * mines[i] will be length 2 and consist of integers in the range [0, N-1].
 */
public class LargestPlusSign {

    /**
     * Leetcode verified
     *
     * @param N
     * @param mines
     * @return
     */
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(grid[i], N);
        }

        for (int[] m : mines) {
            grid[m[0]][m[1]] = 0;
        }

        for (int i = 0; i < N; i++) {

            // go left to right
            int l = 0;
            for (int j = 0; j < N; j++) {
                // j is a column index, iterate from left to right
                // every time check how far left it can reach.
                // if grid[i][j] is 0, l needs to start over from 0 again, otherwise increment
                l = (grid[i][j] == 0 ? 0 : l + 1);
                grid[i][j] = Math.min(grid[i][j], l);
            }

            // go right to left
            int r = 0;
            for (int j = N - 1; j >= 0; j--) {
                // k is a column index, iterate from right to left
                // every time check how far right it can reach.
                // if grid[i][j] is 0, r needs to start over from 0 again, otherwise increment
                r = (grid[i][j] == 0 ? 0 : r + 1);
                grid[i][j] = Math.min(grid[i][j], r);
            }

            // go up to down
            int u = 0;
            for (int j = 0; j < N; j++) {
                // j is a row index, iterate from top to bottom
                // every time check how far up it can reach.
                // if grid[j][i] is 0, u needs to start over from 0 again, otherwise increment
                u = (grid[j][i] == 0 ? 0 : u + 1);
                grid[j][i] = Math.min(grid[j][i], u);
            }

            // go down to up
            int d = 0;
            for (int j = N - 1; j >= 0; j--) {
                // k is a row index, iterate from bottom to top
                // every time check how far down it can reach.
                // if grid[k][i] is 0, d needs to start over from 0 again, otherwise increment
                d = (grid[j][i] == 0 ? 0 : d + 1);
                grid[j][i] = Math.min(grid[j][i], d);
            }
        }

        int res = 0;
        // after four loops each time taking Math.min over the grid value itself
        // all grid values will eventually take the min of the 4 direcitons.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res = Math.max(res, grid[i][j]);
            }
        }

        return res;
    }

    public int orderOfLargestPlusSign5Grids(int N, int[][] mines) {
        // in each cell, store (value, left, top, right, bottom)
        int[][][] m = new int[N][N][5];
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                m[i][j][0] = 1;
            }
        }
        for (int[] pos : mines) {
            m[pos[0]][pos[1]][0] = 0;
        }
        // top-down, left-right
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (m[i][j][0] == 0)
                    continue;
                m[i][j][1] = 1 + ((j > 0) ? m[i][j - 1][1] : 0);
                m[i][j][2] = 1 + ((i > 0) ? m[i - 1][j][2] : 0);
            }
        }
        // bottom up, right-left
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (m[i][j][0] == 0)
                    continue;
                m[i][j][3] = 1 + ((j < N - 1) ? m[i][j + 1][3] : 0);
                m[i][j][4] = 1 + ((i < N - 1) ? m[i + 1][j][4] : 0);
                int size = Integer.MAX_VALUE;
                for (int k = 1; k <= 4; k++) {
                    size = Math.min(size, m[i][j][k]);
                }
                max = Math.max(max, size);
            }
        }
        return max;
    }
}
