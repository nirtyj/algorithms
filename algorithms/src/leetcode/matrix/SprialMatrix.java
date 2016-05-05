package leetcode.matrix;

import java.util.ArrayList;

public class SprialMatrix {

	public static ArrayList<Integer> spiralOrder(int[][] matrix) {

		ArrayList<Integer> result = new ArrayList<>();
		int rowMin = 0;
		int rowMax = matrix.length - 1;
		int colMin = 0;
		int colMax = matrix[0].length - 1;

		while (rowMin <= rowMax && colMin <= colMax) {
			int i = rowMin;
			int j = colMin;
			while (j <= colMax) {
				result.add(matrix[i][j]);
				j++;
			}

			i++;
			j--;
			rowMin = rowMin + 1;

			while (i <= rowMax) {
				result.add(matrix[i][j]);
				i++;
			}

			colMax = colMax - 1;
			j--;
			i--;

			while (j >= colMin) {
				result.add(matrix[i][j]);
				j--;
			}

			rowMax = rowMax - 1;
			i--;
			j++;

			while (i >= rowMin) {
				result.add(matrix[i][j]);
				i--;
			}

			j++;
			i++;
			colMin = colMin + 1;
		}
		return result;
	}
}
