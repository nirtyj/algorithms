package utils;

import java.util.List;

public class MatrixPrintUtils {
	
	public static void printMatrix(List<List<Integer>> matrix) {
		System.out.println("--------------------------Matrix begin----------------------------------------");
		for (int i = 0; i < matrix.size(); i++) {
			for (int j = 0; j < matrix.get(i).size(); j++)
				System.out.print(matrix.get(i).get(j) + "\t");
			System.out.println();
		}
		System.out.println("----------------------------end-----------------------------------------------");
	}

	public static void printMatrix(int[][] matrix) {
		System.out.println("--------------------------Matrix begin----------------------------------------");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++)
				System.out.print(matrix[i][j] + "  ");
			System.out.println();
		}
		System.out.println("----------------------------end-----------------------------------------------");
	}
}
