package leetcode.matrix;

import epi.graph.Coordinate;

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

	private static void markVisited(int[][] matrix, int i, int j) 
	{
		matrix[i][j] = 0;
		for (int[] direction : Coordinate.DIRECTIONS) {
			Coordinate newCoordinates = new Coordinate(i + direction[0], j + direction[1]);
			if (Coordinate.isValidCoordirnate(newCoordinates, matrix)) {
				markVisited(matrix, newCoordinates.x, newCoordinates.y);
			}
		}
	}
}
