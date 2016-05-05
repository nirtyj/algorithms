package leetcode.matrix;

public class Search2DMatrix2 {

	public static boolean searchMatrix(int[][] matrix, int target) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;

		int i = 0;
		int j = matrix[0].length - 1;

		// no check for i<= j. check for if i and j go out of the boundary
		while (j >= 0 && i < matrix.length) {
			if (target < matrix[i][j]) {
				j--;
			} else if (target > matrix[i][j]) {
				i++;
			} else {
				return true;
			}
		}
		return false;
	}
}
