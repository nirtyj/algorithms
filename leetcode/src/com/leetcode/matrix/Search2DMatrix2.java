package com.leetcode.matrix;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * For example,
 * <p>
 * Consider the following matrix:
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * <p>
 * Given target = 20, return false
 */
public class Search2DMatrix2 {

    /**
     * Leetcode verified
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int i = 0; // row start
        int j = matrix[0].length - 1; // row end

        // no check for i<= j. check for if i and j go out of the boundary
        while (j >= 0 && i < matrix.length) {
            if (target < matrix[i][j]) {
                j--;
            } else if (target > matrix[i][j]) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}
