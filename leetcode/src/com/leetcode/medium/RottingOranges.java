package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * In a given grid, each cell can have one of three values:
 *
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
 * If this is impossible, return -1 instead.
 *
 * Example 1:
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Example 2:
 *
 * Input: [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * Example 3:
 *
 * Input: [[0,2]]
 * Output: 0
 * Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 */
public class RottingOranges {

    /**
     * Breadth first search - 2ms
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        int totalNotRotten = 0;
        List<int[]> rottenPlaces = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    rottenPlaces.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    totalNotRotten++;
                }
            }
        }
        if (totalNotRotten == 0) {
            return 0;
        }
        int total = (grid.length) * (grid[0].length);
        int n = 1;
        for (; n <= total; n++) {
            if (rottenPlaces.size() == 0) {
                break;
            }
            List<int[]> newRottenPlaces = new ArrayList<>();
            for (int[] rottenPlace : rottenPlaces) {
                List<int[]> results = markAdjacentRotten(grid, rottenPlace[0], rottenPlace[1]);
                newRottenPlaces.addAll(results);
            }
            rottenPlaces = newRottenPlaces;
        }
        if (isAllRotten(grid)) {
            return n - 2;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return n;
    }

    public List<int[]> markAdjacentRotten(int[][] grid, int i, int j) {
        List<int[]> res = new ArrayList<>();
        if ((i - 1 >= 0) && grid[i - 1][j] == 1) {
            grid[i - 1][j] = 2;
            res.add(new int[]{i - 1, j});
        }
        if ((j - 1 >= 0) && grid[i][j - 1] == 1) {
            grid[i][j - 1] = 2;
            res.add(new int[]{i, j - 1});
        }
        if ((i + 1) < grid.length && grid[i + 1][j] == 1) {
            grid[i + 1][j] = 2;
            res.add(new int[]{i + 1, j});
        }
        if ((j + 1) < grid[0].length && grid[i][j + 1] == 1) {
            grid[i][j + 1] = 2;
            res.add(new int[]{i, j + 1});
        }
        return res;
    }

    public boolean isAllRotten(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
