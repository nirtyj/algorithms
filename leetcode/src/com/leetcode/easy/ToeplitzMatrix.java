package com.leetcode.easy;

/**
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
 * <p>
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * Output: True
 * Explanation:
 * 1234
 * 5123
 * 9512
 * <p>
 * In the above grid, the diagonals are "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]", and in each diagonal all elements are the same, so the answer is True.
 * Example 2:
 * <p>
 * Input: matrix = [[1,2],[2,2]]
 * Output: False
 * Explanation:
 * The diagonal "[1, 2]" has different elements.
 * Note:
 * <p>
 * matrix will be a 2D array of integers.
 * matrix will have a number of rows and columns in range [1, 20].
 * matrix[i][j] will be integers in range [0, 99]
 */
public class ToeplitzMatrix {

    /**
     * Leetcode verified
     *
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        // less than length - 1 to do the +1 check in bounds
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                // starts from 0, so all the equal to check takes care of if start from there
                if (matrix[i][j] != matrix[i + 1][j + 1])
                    return false;
            }
        }
        return true;
    }

    public boolean isToeplitzMatrixII(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return true;
        if (matrix[0].length > 1) {
            int i=0;
            for(int j=0;j<matrix[0].length;j++){
                int first = matrix[i][j];
                int m = i;
                int n = j;
                while(isValid(matrix, m,n)) {
                    if (first != matrix[m][n])
                        return false;
                    m++;
                    n++;
                }
            }
        }
        if (matrix.length > 1) {
            int j=0;
            for(int i=1;i<matrix.length;i++){
                int first = matrix[i][j];
                int m = i;
                int n = j;
                while(isValid(matrix, m,n)) {
                    if (first != matrix[m][n])
                        return false;
                    m++;
                    n++;
                }
            }
        }
        return true;
    }

    boolean isValid(int[][] matrix, int i, int j) {
        if (i <= matrix.length -1  && j<= matrix[0].length -1)
            return true;
        else
            return false;
    }
}
