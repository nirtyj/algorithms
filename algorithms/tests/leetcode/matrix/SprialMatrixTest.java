package leetcode.matrix;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SprialMatrixTest {
	
	public static int[][] getMatrix() {
		int[][] matrix = {
						 {1, 2, 3, 4, 5},
						 {16, 17, 18, 19, 6},
						 {15, 24, 25, 20, 7},
						 {14, 23, 22, 21, 8},
						 {13, 12, 11, 10, 9}
						 };
		return matrix;
	}
	
	@Test
	public void test() {
		int[][] maze = getMatrix();
		ArrayList<Integer> result = SprialMatrix.spiralOrder(maze);
		for (Integer i = 1; i <= 25; i++)
			assertEquals(i, result.get(i - 1));

	}
	
	public static int[][] getMatrix2() {
		int[][] matrix = {
						 {1, 2, 3, 4, 5},
						 {12, 13, 14, 15, 6},
						 {11, 10, 9, 8, 7},
						 };
		return matrix;
	}
	
	@Test
	public void test2() {
		int[][] maze = getMatrix2();
		ArrayList<Integer> result = SprialMatrix.spiralOrder(maze);
		for (Integer i = 1; i <= 15; i++)
			assertEquals(i, result.get(i - 1));

	}
	
	public static int[][] getMatrix3() {
		int[][] matrix = {
						 {1, 2, 3, 4, 5}
						 };
		return matrix;
	}
	
	@Test
	public void test3() {
		int[][] maze = getMatrix3();
		ArrayList<Integer> result = SprialMatrix.spiralOrder(maze);
		for (Integer i = 1; i <= 5; i++)
			assertEquals(i, result.get(i - 1));

	}
	
	public static int[][] getMatrix4() {
		int[][] matrix = {
						 {2},
						 {4},
						 {6},
						 {8},
						 {10}
						 };
		return matrix;
	}
	
	@Test
	public void test4() {
		int[][] maze = getMatrix4();
		ArrayList<Integer> result = SprialMatrix.spiralOrder(maze);
		for (Integer i = 1; i <= 5; i++)
			assertEquals((Integer)(i*2), result.get(i - 1));

	}
}
