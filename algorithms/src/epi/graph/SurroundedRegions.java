package epi.graph;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {

	public static void fillRegions(int[][] matrix) {

		boolean[][] visited = new boolean[matrix.length][matrix.length];

		// columns
		for (int i = 0; i < matrix.length; i++) {
			// first column
			if (visited[i][0] == false)
				markVisited(matrix, visited, i, 0);
			// last column
			if (visited[i][matrix.length - 1] == false)
				markVisited(matrix, visited, i, matrix.length - 1);
		}

		// rows
		for (int i = 0; i < matrix.length; i++) {
			// first row
			if (visited[0][i] == false)
				markVisited(matrix, visited, 0, i);
			// last rwo
			if (visited[matrix.length - 1][i] == false)
				markVisited(matrix, visited, matrix.length - 1, i);
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (visited[i][j] == false) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	private static void markVisited(int[][] matrix, boolean[][] visited, int x, int y) 
	{
		visited[x][y] = true;
		if (matrix[x][y] == 0)
			return;
		
		Queue<Coordinate> queue = new LinkedList<Coordinate>();
		queue.add(new Coordinate(x, y));
		while (!queue.isEmpty()) {
			Coordinate curr = queue.poll();
			for (int[] direction : Coordinate.DIRECTIONS) {
				Coordinate newCoordinate = new Coordinate(curr.x + direction[0], curr.y + direction[1]);
				if (Coordinate.isValidCoordirnate(newCoordinate, matrix)
						&& visited[newCoordinate.x][newCoordinate.y] == false) {
					visited[newCoordinate.x][newCoordinate.y] = true;
					queue.add(newCoordinate);
				}
			}
		}
	}
}
