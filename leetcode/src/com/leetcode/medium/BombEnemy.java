package com.leetcode.medium;

/**
Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero),
return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits
the wall since the wall is too strong to be destroyed.
Note that you can only put the bomb at an empty cell.

Example:
For the given grid

0 E 0 0
E 0 W E
0 E 0 0

return 3. (Placing a bomb at (1,1) kills 3 enemies)
*/
public class BombEnemy {

	/**
	 * Leetcode verified
	 * @param grid
	 * @return
	 */
	public int maxKilledEnemies(char[][] grid) {
		int maxEnemies = 0;
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '0') {
					int killShots = findKillShot(grid, i, j);
					maxEnemies = Math.max(maxEnemies, killShots);
				}
			}
		}
		return maxEnemies;
	}

	private int findKillShot(char[][] grid, int i, int j) {
		int killShots = 0;
		int rl = j;
		int rr = j;
		int ju = i;
		int jd = i;
		// going left
		while (rl >= 0) {
			if (grid[i][rl] == 'W') {
				break;
			}
			if (grid[i][rl] == 'E') {
				killShots++;
			}
			rl--;
		}
		// going right
		while (rr < grid[0].length) {
			if (grid[i][rr] == 'W') {
				break;
			}
			if (grid[i][rr] == 'E') {
				killShots++;
			}
			rr++;
		}
		// going up
		while (ju >= 0) {
			if (grid[ju][j] == 'W') {
				break;
			}
			if (grid[ju][j] == 'E') {
				killShots++;
			}
			ju--;
		}
		// going down
		while (jd < grid.length) {
			if (grid[jd][j] == 'W') {
				break;
			}
			if (grid[jd][j] == 'E') {
				killShots++;
			}
			jd++;
		}
		return killShots;
	}
}
