package epi.searching;

import java.util.List;

public class Search2DSortedArray {

	public static boolean findElement(List<List<Integer>> matrix, int key) {
		int row = 0;
		int col = matrix.get(0).size() - 1;
		while (row < matrix.size() && col >=0) {
			if (key == matrix.get(row).get(col))
				return true;
			else if (key > matrix.get(row).get(col))
				row++;
			else
				col--;
		}
		return false;
	}
}
