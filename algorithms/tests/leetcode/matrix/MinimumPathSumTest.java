package leetcode.matrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinimumPathSumTest {

	public static int[][] getMatrix() {
		int[][] matrix = {
						 {1, 2, 3},
						 {3, 4, 6}
						 };
		return matrix;
	}
	
	@Test
	public void test() {
		int[][] matrix = getMatrix();
		assertEquals(12, MinimumPathSum.minPathSum(matrix));
	}
	
	public static int[][] getMatrix2() {
		int[][] matrix = {
						 {1, 2, 3, 4},
						 {5, 6, 7, 8},
						 {9, 1, 2, 5}
						 };
		return matrix;
	}
	
	@Test
	public void test2() {
		int[][] matrix = getMatrix2();
		assertEquals(17, MinimumPathSum.minPathSum(matrix));
	}

}
