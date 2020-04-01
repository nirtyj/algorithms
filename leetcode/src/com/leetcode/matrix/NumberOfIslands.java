package com.leetcode.matrix;

import com.leetcode.common.Coordinate;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 * <p>
 * Example 2:
 * <p>
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 */
public class NumberOfIslands {

    public static int numIslands(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 1) {
                    markVisited(matrix, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void markVisited(int[][] matrix, int i, int j) {
        matrix[i][j] = 0;
        for (int[] direction : Coordinate.DIRECTIONS) {
            Coordinate newCoordinates = new Coordinate(i + direction[0], j + direction[1]);
            if (Coordinate.isValidCoordirnate(newCoordinates, matrix)) {
                markVisited(matrix, newCoordinates.x, newCoordinates.y);
            }
        }
    }

    /**
     * Leetcode verified
     *
     * @param matrix
     * @return
     */
    public int numIslands(char[][] matrix) {
        // do null check, and size > 0 check
        if (matrix == null || matrix.length <= 0)
            return 0;

        boolean[][] visitedArray = new boolean[matrix.length][matrix[0].length];
        int count = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                count = count + recursiveHelper(matrix, visitedArray, i, j);
            }
        }
        return count;
    }

    public int recursiveHelper(char[][] matrix, boolean[][] visitedArray, int i, int j) {
        // base condition
        if (i < 0 || i > matrix.length - 1 || j < 0 || j > matrix[0].length - 1)
            return 0;

        if (visitedArray[i][j] == true)
            return 0;

        visitedArray[i][j] = true;
        if (matrix[i][j] == '0') {
            return 0;
        } else {
            recursiveHelper(matrix, visitedArray, i - 1, j);
            recursiveHelper(matrix, visitedArray, i, j - 1);
            recursiveHelper(matrix, visitedArray, i + 1, j);
            recursiveHelper(matrix, visitedArray, i, j + 1);
        }
        return 1;
    }
}
