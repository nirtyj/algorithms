package epi.graph;

import static org.junit.Assert.*;

import org.junit.Test;

import utils.MatrixPrintUtils;

public class SurroundedRegionsTest {


	public static int[][] getMatrix() {
		int[][] matrix = {
						 {1, 1, 0, 1, 0},
						 {0, 0, 0, 1, 0},
						 {0, 1, 1, 0, 1},
						 {0, 1, 0, 1, 0},
						 {1, 0, 0, 0, 1}
						 };
		return matrix;
	}
	
	public static int[][] getResultMatrix() {
		int[][] matrix = {
						 {1, 1, 0, 1, 0},
						 {0, 0, 0, 1, 0},
						 {0, 0, 0, 0, 1},
						 {0, 0, 0, 0, 0},
						 {1, 0, 0, 0, 1}
						 };
		return matrix;
	}
	
	@Test
	public void test() {		
		int[][] maze = getMatrix();
		SurroundedRegions.fillRegions(maze);
		MatrixPrintUtils.printMatrix(maze);
		int[][] resultmaze = getResultMatrix();
		for(int i=0;i<maze.length;i++)
			for(int j=0;j<maze.length;j++)
				assertEquals(resultmaze[i][j], maze[i][j]);
	}
	
	public static int[][] getMatrix2() {
		int[][] matrix = {
						 {0, 0, 0, 1, 0},
						 {0, 1, 0, 1, 0},
						 {0, 0, 1, 1, 0},
						 {0, 0, 1, 0, 0},
						 {1, 0, 0, 0, 1}
						 };
		return matrix;
	}
	
	public static int[][] getResultMatrix2() {
		int[][] matrix = {
						 {0, 0, 0, 1, 0},
						 {0, 0, 0, 1, 0},
						 {0, 0, 1, 1, 0},
						 {0, 0, 1, 0, 0},
						 {1, 0, 0, 0, 1}
						 };
		return matrix;
	}
	
	@Test
	public void test2() {		
		int[][] maze = getMatrix2();
		SurroundedRegions.fillRegions(maze);
		MatrixPrintUtils.printMatrix(maze);
		int[][] resultmaze = getResultMatrix2();
		for(int i=0;i<maze.length;i++)
			for(int j=0;j<maze.length;j++)
				assertEquals(resultmaze[i][j], maze[i][j]);
	}

}
