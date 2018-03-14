package com.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;

/**
A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

For example, given three people living at (0,0), (0,4), and (2,2):

1 - 0 - 0 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.
*/
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
