package leetcode.matrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class Search2DMatrix2Test {

	public static int[][] getMatrix2() {
		int[][] matrix = {
						 {1,   4,  7, 11, 15},
						 {2,   5,  8, 12, 19},
						 {3,   6,  9, 16, 22},
						 {10, 13, 14, 17, 24},
						 {18, 21, 23, 26, 30}
						 };
		return matrix;
	}
	
	@Test
	public void test2() {
		int[][] matrix = getMatrix2();
		assertTrue(Search2DMatrix2.searchMatrix(matrix, 5));
		assertTrue(Search2DMatrix2.searchMatrix(matrix, 30));
		assertTrue(Search2DMatrix2.searchMatrix(matrix, 21));
		assertTrue(Search2DMatrix2.searchMatrix(matrix, 16));
		assertFalse(Search2DMatrix2.searchMatrix(matrix, -1));
		assertFalse(Search2DMatrix2.searchMatrix(matrix, 50));
		assertFalse(Search2DMatrix2.searchMatrix(matrix, 20));
	}

}
