package leetcode.matrix;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leetcode.matrix.UniquePaths2;

public class UniquePaths2Test {

	public static int[][] getMatrix2() {
		int[][] matrix = {
						 {0, 0, 0},
						 {0, 1, 0},
						 {0, 0, 0},
						 };
		return matrix;
	}
	
	@Test
	public void test() {
		int[][] maze = getMatrix2();
		assertEquals(2, UniquePaths2.uniquePathsWithObstacles(maze));
	}

}
