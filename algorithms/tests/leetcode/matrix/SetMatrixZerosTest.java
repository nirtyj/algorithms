package leetcode.matrix;

import static org.junit.Assert.*;

import org.junit.Test;

import com.leetcode.matrix.SetMatrixZeros;

public class SetMatrixZerosTest {

	public static int[][] getMatrix() {
		int[][] matrix = {
						 {1, 1, 1, 1, 0},
						 {1, 1, 0, 1, 0},
						 {1, 1, 1, 0, 0},
						 {1, 1, 0, 0, 0},
						 {1, 0, 0, 0, 0}
						 };
		return matrix;
	}
	
	@Test
	public void test() {		
		int[][] maze = getMatrix();
		SetMatrixZeros.setZeroes(maze);
		for(int i = 0; i < maze.length; i++)
			for(int j = 0; j < maze[0].length; j++)
				assertEquals(0, maze[i][j]);
		
	}
	
	public static int[][] getMatrix2() {
		int[][] matrix = {
						 {1, 1, 9, 1, 0},
						 {1, 1, 8, 1, 3},
						 {1, 1, 5, 0, 0},
						 {1, 1, 6, 0, 0},
						 {1, 0, 7, 0, 0}
						 };
		return matrix;
	}
	
	@Test
	public void test1() {		
		int[][] maze = getMatrix2();
		SetMatrixZeros.setZeroes(maze);
		for(int i = 0; i < maze.length; i++)
		{
			for(int j = 0; j < maze[0].length; j++)
			{
				if(i==1 && j==0)
					assertEquals(1, maze[i][j]);
				else if(i==1&& j == 2)
					assertEquals(8, maze[i][j]);
				else
					assertEquals(0, maze[i][j]);
			}
		}
				
		
	}

}
