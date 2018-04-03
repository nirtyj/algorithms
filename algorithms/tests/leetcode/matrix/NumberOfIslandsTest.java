package leetcode.matrix;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leetcode.matrix.NumberOfIslands;

public class NumberOfIslandsTest {

	public static int[][] getMatrix() {
		int[][] matrix = {
						 {1, 1, 1, 1, 0},
						 {1, 1, 0, 1, 0},
						 {1, 1, 1, 0, 0},
						 {0, 1, 0, 0, 0},
						 {0, 0, 0, 0, 0}
						 };
		return matrix;
	}
	
	@Test
	public void test() {		
		int[][] maze = getMatrix();
		assertEquals(1, NumberOfIslands.numIslands(maze));
	}
	
	public static int[][] getMatrix2() {
		int[][] matrix = {
						 {1, 1, 1, 0, 0},
						 {1, 1, 0, 1, 0},
						 {1, 0, 1, 0, 0},
						 {0, 1, 0, 1, 0},
						 {0, 0, 0, 0, 1}
						 };
		return matrix;
	}
	
	@Test
	public void test2() {		
		int[][] maze = getMatrix2();
		assertEquals(6, NumberOfIslands.numIslands(maze));
	}
}
