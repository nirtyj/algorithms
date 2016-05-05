package leetcode.matrix;

public class SetMatrixZeros {

	public static void setZeroes(int[][] matrix) {

		boolean isRowContainsZero = false;
		boolean isColContainsZero = false;

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0)
				isColContainsZero = true;
		}
		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0)
				isRowContainsZero = true;
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix.length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		if (isColContainsZero) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}

		if (isRowContainsZero) {
			for (int i = 0; i < matrix[0].length; i++) {
				matrix[0][i] = 0;
			}
		}

	}
}
