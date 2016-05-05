package leetcode.matrix;

public class UniquePaths2 {

	public static int uniquePathsWithObstacles(int[][] grid) {

		if (grid == null)
			return 0;

		int m = grid.length;
		int n = grid[0].length;

		int[][] dp = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if (grid[i][j] == 1) {
					dp[i][j] = 0;
					continue;
				}

				// check for i-1, j-1 out of matrix range.
				if ((i - 1) >= 0 && (j - 1) >= 0) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				} else if ((i - 1) >= 0 && (j - 1) < 0) {
					dp[i][j] = dp[i - 1][j];
				} else if ((i - 1) < 0 && (j - 1) >= 0) {
					dp[i][j] = dp[i][j - 1];
				} else {
					dp[i][j] = 1;
				}
			}
		}
		return dp[m - 1][n - 1];
	}
}
