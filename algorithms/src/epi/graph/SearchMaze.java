package epi.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchMaze {

	public static List<Coordinate> searchMaze(int[][] maze, Coordinate s, Coordinate e) {
		List<Coordinate> paths = new ArrayList<>();
		paths.add(s);
		boolean success = searchMazeHelper(maze, s, e, paths);
		if (success)
			return paths;
		else
			return Collections.emptyList();
	}

	private static boolean searchMazeHelper(int[][] maze, Coordinate cur, Coordinate end, List<Coordinate> path) {

		if (cur.equals(end))
			return true;

		for (int[] direction : Coordinate.DIRECTIONS) {
			Coordinate newCoordinates = new Coordinate(cur.x + direction[0], cur.y + direction[1]);
			if (Coordinate.isValidCoordirnate(newCoordinates, maze)) {
				path.add(newCoordinates);
				maze[newCoordinates.x][newCoordinates.y] = 0;
				boolean result = searchMazeHelper(maze, newCoordinates, end, path);
				if (result)
					return true;
				path.remove(path.size() -1 );
			}
		}

		return false;
	}
}
