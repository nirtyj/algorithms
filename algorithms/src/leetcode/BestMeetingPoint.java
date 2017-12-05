package leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class BestMeetingPoint {

	/**
	 * 1. Store all horizontal and vertical positions of all group member. 
	 * 2. Now sort it to find minimum middle position, which will be the best
	 * meeting point. 
	 * 3. Find the distance of all members from best meeting point.
	 * 
	 * @param grid
	 * @return
	 */
	public int minTotalDistance(int[][] grid) {

		ArrayList<Integer> rows = new ArrayList<>();
		ArrayList<Integer> cols = new ArrayList<>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					rows.add(i);
					cols.add(j);
				}
			}
		}

		Collections.sort(rows);
		Collections.sort(cols);

		int x = rows.get(rows.size() / 2);
		int y = cols.get(cols.size() / 2);

		int totalDistance = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					totalDistance += Math.abs(x - i) + Math.abs(y - j);
				}
			}
		}

		return totalDistance;

	}
}
