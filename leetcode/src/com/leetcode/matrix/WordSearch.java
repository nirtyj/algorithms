package com.leetcode.matrix;

import com.leetcode.common.Coordinate;

/**
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/
public class WordSearch {

	/**
	 * Leetcode verified
	 * @param board
	 * @param word
	 * @return
	 */
	public boolean exist(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;

		boolean result = false;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (dfs(board, word, i, j, 0)) {
					result = true;
				}
			}
		}

		return result;
	}

	public boolean dfs(char[][] board, String word, int i, int j, int k) {
		int m = board.length;
		int n = board[0].length;

		if (i < 0 || j < 0 || i >= m || j >= n) {
			return false;
		}

		if (board[i][j] == word.charAt(k)) {
			char temp = board[i][j];
			board[i][j] = '#';
			if (k == word.length() - 1) {
				return true;
			} else if (dfs(board, word, i - 1, j, k + 1) || dfs(board, word, i + 1, j, k + 1)
					|| dfs(board, word, i, j - 1, k + 1) || dfs(board, word, i, j + 1, k + 1)) {
				return true;
			}
			board[i][j] = temp;
		}

		return false;
	}

	public static boolean exist2(char[][] board, String word) {

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

		// revert back to old val
		board[i][j] = temp;
		return result;
	}

	private static boolean isValidij(char[][] board, int x, int y, char c) {
		if ((x >= 0 && x < board.length) && (y >= 0 && y < board[0].length) && board[x][y] == c)
			return true;
		return false;
	}
}
