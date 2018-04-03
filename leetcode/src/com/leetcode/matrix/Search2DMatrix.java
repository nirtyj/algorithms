package com.leetcode.matrix;

/**
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true
*/
public class Search2DMatrix {

	/**
	 * Leetcode verified
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;

		int m = matrix.length;
		int n = matrix[0].length;

		int start = 0;
		int end = m * n - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			int midX = mid / n;
			int midY = mid % n;

			if (matrix[midX][midY] == target)
				return true;

			if (matrix[midX][midY] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return false;
	}

	public static boolean searchMatrix1(int[][] matrix, int target) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;

		int mini = 0;
		int maxi = matrix.length - 1;

		while (mini < maxi) {
			int midi = (int) (mini + Math.ceil((double) ((double) (maxi - mini) / 2.0)));

			if (matrix[midi][0] == target)
				return true;

			if (target < matrix[midi][0]) {
				maxi = midi - 1;
			} else {
				mini = midi;
			}
		}

		int minj = 0;
		int maxj = matrix[0].length - 1;

		while (minj <= maxj) {
			int midj = minj + (maxj - minj) / 2;

			if (matrix[mini][midj] == target)
				return true;

			if (target < matrix[mini][midj]) {
				maxj = midj - 1;
			} else {
				minj = midj + 1;
			}
		}

		return false;

	}
}
