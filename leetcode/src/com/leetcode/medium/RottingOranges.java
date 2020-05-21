package com.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    /**
     * Better easy way.
     * @param grid
     * @return
     */
    public int orangesRotting2(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;
        //Put the position of all rotten oranges in queue
        //count the number of fresh oranges
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i , j});
                }
                else if(grid[i][j] == 1) {
                    count_fresh++;
                }
            }
        }
        //if count of fresh oranges is zero --> return 0
        if(count_fresh == 0) return 0;
        int count = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        //bfs starting from initially rotten oranges
        while(!queue.isEmpty()) {
            ++count;
            int size = queue.size();
            for(int i = 0 ; i < size ; i++) {
                int[] point = queue.poll();
                for(int dir[] : dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    //if x or y is out of bound
                    //or the orange at (x , y) is already rotten
                    //or the cell at (x , y) is empty
                    //we do nothing
                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) continue;
                    //mark the orange at (x , y) as rotten
                    grid[x][y] = 2;
                    //put the new rotten orange at (x , y) in queue
                    queue.offer(new int[]{x , y});
                    //decrease the count of fresh oranges by 1
                    count_fresh--;
                }
            }
        }
        return count_fresh == 0 ? count-1 : -1;
    }
}
