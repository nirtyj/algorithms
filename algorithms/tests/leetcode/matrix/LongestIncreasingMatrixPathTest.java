package leetcode.matrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestIncreasingMatrixPathTest {


	public static int[][] getMatrix2() {
		int[][] matrix = {
						 {3, 4, 5},
						 {3, 2, 6},
						 {2, 2, 1}
						 };
		return matrix;
	}
	
	@Test
	public void test2() {
		int[][] matrix = getMatrix2();
		assertEquals(4, LongestIncreasingMatrixPath.longestIncreasingPath(matrix));
	}

	public static int[][] getMatrix3() {
		int[][] matrix = {
						 {9, 9, 4},
						 {6, 6, 8},
						 {2, 1, 1}
						 };
		return matrix;
	}
	
	@Test
	public void test3() {
		int[][] matrix = getMatrix3();
		assertEquals(4, LongestIncreasingMatrixPath.longestIncreasingPath(matrix));
	}

	
}
