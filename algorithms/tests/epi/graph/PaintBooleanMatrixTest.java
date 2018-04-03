package epi.graph;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import utils.MatrixPrintUtils;

public class PaintBooleanMatrixTest {

	public static int[][] getMatrix() {
		int[][] matrix = {
						 {1, 1, 1, 0, 0},
						 {0, 0, 0, 1, 0},
						 {0, 1, 1, 1, 1},
						 {0, 1, 0, 0, 1},
						 {0, 0, 1, 1, 1}
						 };
		return matrix;
	}
	
	public static int[][] getResultMatrix() {
		int[][] matrix = {
						 {1, 1, 1, 0, 0},
						 {0, 0, 0, 0, 0},
						 {0, 0, 0, 0, 0},
						 {0, 0, 0, 0, 0},
						 {0, 0, 0, 0, 0}
						 };
		return matrix;
	}
	
	@Test
	public void test() {
		Coordinate s = new Coordinate(3, 1);
		int[][] maze = getMatrix();
		PaintBooleanMatrix.flipColor(maze, s);
		MatrixPrintUtils.printMatrix(maze);
		int[][] resultmaze = getResultMatrix();
		for(int i=0;i<maze.length;i++)
			for(int j=0;j<maze.length;j++)
				assertEquals(resultmaze[i][j], maze[i][j]);
	}

	@Test
	public void test1() {
		Coordinate s = new Coordinate(2, 3);
		int[][] maze = getMatrix();
		PaintBooleanMatrix.flipColor(maze, s);
		MatrixPrintUtils.printMatrix(maze);
		int[][] resultmaze = getResultMatrix();
		for(int i=0;i<maze.length;i++)
			for(int j=0;j<maze.length;j++)
				assertEquals(resultmaze[i][j], maze[i][j]);
	}

}
