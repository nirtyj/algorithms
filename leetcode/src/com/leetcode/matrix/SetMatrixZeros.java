package com.leetcode.matrix;

/**
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
*/
public class SetMatrixZeros {

	/**
	 * Leetcode verified
	 * @param matrix
	 */
	public void setZeroes(int[][] matrix) {

		boolean isRowContainsZero = false;
		boolean isColContainsZero = false;

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0)
				isColContainsZero = true;
		}
		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0)
				isRowContainsZero = true;
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		if (isColContainsZero) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}

		if (isRowContainsZero) {
			for (int i = 0; i < matrix[0].length; i++) {
				matrix[0][i] = 0;
			}
		}
	}
}
