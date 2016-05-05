package leetcode.matrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotateImageTest {

	
	public static int[][] getMatrix() {
		int[][] matrix = {
						 {1, 2, 3, 4, 5},
						 {6, 7, 8, 9, 10},
						 {11, 12, 13, 14, 15},
						 {16, 17, 18, 19, 20},
						 {21, 22, 23, 24, 25}
						 };
		return matrix;
	}
	
	public static int[][] getResultMatrix() {
		int[][] matrix = {
						 {21, 16, 11, 6, 1},
						 {22, 17, 12, 7, 2},
						 {23, 18, 13, 8, 3},
						 {24, 19, 14, 9, 4},
						 {25, 20, 15, 10, 5}
						 };
		return matrix;
	}
	
	@Test
	public void test() {
		int[][] maze = getMatrix();
		int[][] result = getResultMatrix();
		RotateImage.rotate(maze);
		for(int i=0; i<maze.length;i++)
			for(int j=0;j<maze.length;j++)
				assertEquals(result[i][j], maze[i][j]);
	}

}
