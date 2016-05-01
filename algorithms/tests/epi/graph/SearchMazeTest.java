package epi.graph;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class SearchMazeTest {

	public static int[][] getMatrix() {
		int[][] matrix = {
						 {1, 1, 1, 1, 1},
						 {0, 0, 0, 0, 1},
						 {1, 1, 1, 1, 1},
						 {1, 1, 0, 0, 0},
						 {1, 1, 1, 1, 1}
						 };
		return matrix;
	}
	
	@Test
	public void test() {
		Coordinate s = new Coordinate(0, 0);
		Coordinate e = new Coordinate(4, 4);
		int[][] maze = getMatrix();
		List<Coordinate> paths =  SearchMaze.searchMaze(maze, s, e);
		assertEquals(new Coordinate(0, 0), paths.get(0));
		assertEquals(new Coordinate(0, 1), paths.get(1));
		assertEquals(new Coordinate(0, 2), paths.get(2));
		assertEquals(new Coordinate(0, 3), paths.get(3));
		assertEquals(new Coordinate(0, 4), paths.get(4));
		
		assertEquals(new Coordinate(1, 4), paths.get(5));
		
		assertEquals(new Coordinate(2, 4), paths.get(6));
		assertEquals(new Coordinate(2, 3), paths.get(7));
		assertEquals(new Coordinate(2, 2), paths.get(8));
		assertEquals(new Coordinate(2, 1), paths.get(9));
		
		assertEquals(new Coordinate(3, 1), paths.get(10));
		
		assertEquals(new Coordinate(4, 1), paths.get(11));
		assertEquals(new Coordinate(4, 2), paths.get(12));
		assertEquals(new Coordinate(4, 3), paths.get(13));
		assertEquals(new Coordinate(4, 4), paths.get(14));
	}

}
