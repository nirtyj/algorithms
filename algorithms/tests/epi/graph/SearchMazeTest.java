package epi.graph;

import java.util.List;

import org.junit.Test;

import epi.graph.SearchMaze.Coordinate;

public class SearchMazeTest {

	public static int[][] getMatrix() {
		int[][] matrix = {
						 {1, 1, 1, 1, 1},
						 {0, 0, 0, 0, 1},
						 {0, 1, 1, 1, 1},
						 {0, 1, 0, 0, 0},
						 {0, 1, 1, 1, 1}
						 };
		return matrix;
	}
	
	@Test
	public void test() {
		Coordinate s = new Coordinate(0, 0);
		Coordinate e = new Coordinate(4, 4);
		int[][] maze = getMatrix();
		List<Coordinate> paths =  SearchMaze.searchMaze(maze, s, e);
		for(Coordinate c : paths)
		{
			System.out.println( c.x + " , " + c.y);
		}		
	}

}
