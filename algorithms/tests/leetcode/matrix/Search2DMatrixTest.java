package leetcode.matrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class Search2DMatrixTest {

	public static int[][] getMatrix2() {
		int[][] matrix = {
						 {1, 3, 5, 7},
						 {10, 11, 16, 20},
						 {23, 30, 34, 50},
						 };
		return matrix;
	}
	
	@Test
	public void test2() {
		int[][] matrix = getMatrix2();
		assertTrue(Search2DMatrix.searchMatrix(matrix, 3));
		assertTrue(Search2DMatrix.searchMatrix(matrix, 34));
		assertTrue(Search2DMatrix.searchMatrix(matrix, 50));
		assertTrue(Search2DMatrix.searchMatrix(matrix, 16));
		assertFalse(Search2DMatrix.searchMatrix(matrix, 100));
		assertFalse(Search2DMatrix.searchMatrix(matrix, 0));
		assertFalse(Search2DMatrix.searchMatrix(matrix, 15));
	}
	

}
