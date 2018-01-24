package leetcode.matrix;

import epi.graph.Coordinate;

public class NumberOfIslands {

	/**
	 * Leetcode verified
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

	public int countIslands(int[][] matrix) {
		// do null check, and size > 0 check
		if (matrix == null || matrix.length < 0)
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

	public int recursiveHelper(int[][] matrix, boolean[][] visitedArray, int i, int j) {
		// base condition
		if (i < 0 || i > matrix.length - 1 || j < 0 || j > matrix[0].length - 1)
			return 0;

		if (visitedArray[i][j] == true)
			return 0;

		visitedArray[i][j] = true;
		if (matrix[i][j] == 0) {
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
