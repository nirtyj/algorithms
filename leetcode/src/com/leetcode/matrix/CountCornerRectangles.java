package com.leetcode.matrix;

/**
 * Given a grid where each entry is only 0 or 1, find the number of corner rectangles.
 * <p>
 * A corner rectangle is 4 distinct 1s on the grid that form an axis-aligned rectangle. Note that only the corners need to have the value 1. Also, all four 1s used must be distinct.
 * <p>
 * Example 1:
 * <p>
 * Input: grid =
 * [[1, 0, 0, 1, 0],
 * [0, 0, 1, 0, 1],
 * [0, 0, 0, 1, 0],
 * [1, 0, 1, 0, 1]]
 * Output: 1
 * Explanation: There is only one corner rectangle, with corners grid[1][2], grid[1][4], grid[3][2], grid[3][4].
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: grid =
 * [[1, 1, 1],
 * [1, 1, 1],
 * [1, 1, 1]]
 * Output: 9
 * Explanation: There are four 2x2 rectangles, four 2x3 and 3x2 rectangles, and one 3x3 rectangle.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: grid =
 * [[1, 1, 1, 1]]
 * Output: 0
 * Explanation: Rectangles must have four distinct corners.
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of rows and columns of grid will each be in the range [1, 200].
 * Each grid[i][j] will be either 0 or 1.
 * The number of 1s in the grid will be at most 6000.
 */
public class CountCornerRectangles {

    /**
     * Leetcode verified
     *
     * @param grid
     * @return
     */
    public int countCornerRectangles(int[][] grid) {
        int rectangles = 0;
        for (int i = 0; i < grid.length - 1; i++) { // fix row1
            for (int j = i + 1; j < grid.length; j++) { // fix row2
                int sides = 0;
                for (int k = 0; k < grid[0].length; k++) {
                    if (grid[i][k] == 1 && grid[j][k] == 1) sides++; // count how many corners are there
                }
                if (sides > 0)
                    rectangles = rectangles + (sides * (sides - 1) / 2); // no of rectangles is combination of corners. 3 sides is 3 rectangles n * n-1 / 2
            }
        }
        return rectangles;
    }
}
