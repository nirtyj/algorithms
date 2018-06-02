package com.leetcode.matrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotateImageTest {

	@Test
	public void test() {
		int[][] matrix = { {1,2,3}, {4,5, 6},{7, 8, 9}};
		RotateImage.rotate(matrix);
		RotateImage.rotate(matrix);
		RotateImage.rotate(matrix);
		System.out.println();
	}
	
	@Test
	public void test270() {
		int[][] matrix = { {1,2,3}, {4,5, 6},{7, 8, 9}};
		RotateImage.rotate270(matrix);
		System.out.println();
	}

}
