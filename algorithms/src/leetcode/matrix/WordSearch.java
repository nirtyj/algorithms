package leetcode.matrix;

import epi.graph.Coordinate;

public class WordSearch {

	public static boolean exist(char[][] board, String word) {

		if (word == null || word.isEmpty() || board == null)
			return false;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {

				if (board[i][j] == word.charAt(0)) {
					boolean result = dfsHelper(board, i, j, 0, word);
					if (result)
						return result;
				}
			}
		}

		return false;

	}

	private static boolean dfsHelper(char[][] board, int i, int j, int currentIndex, String word) {

		if (currentIndex == word.length() - 1)
			return true;

		if (currentIndex > word.length() - 1)
			return false;

		if (board[i][j] != word.charAt(currentIndex))
			return false;

		// mark seen
		char temp = board[i][j];
		board[i][j] = '0';

		boolean result = false;
		
		for (int[] direction : Coordinate.DIRECTIONS) {

			int newx = i + direction[0];
			int newy = j + direction[1];
			if (isValidij(board, newx, newy, word.charAt(currentIndex + 1))) {
				result = dfsHelper(board, newx, newy, currentIndex + 1, word);
				if (result)
					break;
			}
		}

		//revert back to old val
		board[i][j] = temp;
		return result;
	}

	private static boolean isValidij(char[][] board, int x, int y, char c) {
		if ((x >= 0 && x < board.length) && (y >= 0 && y < board[0].length) && board[x][y] == c)
			return true;
		return false;
	}
}
