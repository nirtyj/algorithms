package com.leetcode.hard;

/**
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
*/
public class MinEditDistance {

	/**
	 * Leetcode verified
	 * @param word1
	 * @param word2
	 * @return
	 */
	public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();

		int[][] cost = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++)
			cost[i][0] = i;
		for (int j = 0; j <= n; j++)
			cost[0][j] = j;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (word1.charAt(i) == word2.charAt(j))
					cost[i + 1][j + 1] = cost[i][j];
				else {
					int replace = cost[i][j];
					int delete = cost[i][j + 1];
					int insert = cost[i + 1][j];
					cost[i + 1][j + 1] = Math.min(replace, Math.min(delete, insert)) + 1;
				}
			}
		}
		return cost[m][n];
	}
}
