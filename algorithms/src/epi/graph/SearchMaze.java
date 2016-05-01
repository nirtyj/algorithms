package epi.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchMaze {

	public static class Coordinate {
		public int x, y;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Coordinate other = (Coordinate) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static List<Coordinate> searchMaze(int[][] maze, Coordinate s, Coordinate e) {

		List<Coordinate> paths = new ArrayList<>();
		boolean success = searchMazeHelper(maze, s, e, paths);
		if (success)
			return paths;
		else
			return Collections.emptyList();
	}

	private static boolean searchMazeHelper(int[][] maze, Coordinate cur, Coordinate end, List<Coordinate> path) {

		if (cur.equals(end))
			return true;

		final int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

		for (int[] direction : directions) {
			Coordinate newCoordinates = new Coordinate(cur.x + direction[0], cur.y + direction[1]);
			if (isValidCoordirnate(newCoordinates, maze)) {
				path.add(newCoordinates);
				maze[newCoordinates.x][newCoordinates.y] = 0;
				boolean result = searchMazeHelper(maze, newCoordinates, end, path);
				if (result)
					return true;
			}
		}

		return false;
	}

	private static boolean isValidCoordirnate(Coordinate newCoordinates, int[][] maze) {

		if ((newCoordinates.x >= 0 && newCoordinates.x < maze.length)
				&& (newCoordinates.y >= 0 && newCoordinates.y < maze.length)
				&& maze[newCoordinates.x][newCoordinates.y] != 0)
			return true;
		return false;
	}

}
