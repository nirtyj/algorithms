package com.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SkylineProblem {

    /**
     * https://briangordon.github.io/2014/08/the-skyline-problem.html
     * 1. visit all start points and all end points in order;
     * 2. when visiting a point, we need to know whether it is a start point or a
     * end point, based on which we can add a height or delete a height from
     * our data structure;
     * To achieve this, his implementation:
     * <p>
     * 1. use a int[][] to collect all [start point, - height] and [end point, height]
     * for every building;
     * 2. sort it, firstly based on the first value, then use the second to break
     * ties;
     * Thus,
     * <p>
     * 1. we can visit all points in order;
     * 2. when points have the same value, higher height will shadow the lower one;
     * 3. we know whether current point is a start point or a end point based on the
     * sign of its height;
     */
    public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for (int[] b : buildings) {
            // start point has negative height value
            height.add(new int[]{b[0], -b[2]});
            // end point has normal height value
            height.add(new int[]{b[1], b[2]});
        }

        // sort $height, based on the first value, if necessary, use the second to
        // break ties
        Collections.sort(height, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        // Use a maxHeap to store possible heights
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        // Provide a initial value to make it more consistent
        pq.offer(0);

        // Before starting, the previous max height is 0;
        int prev = 0;

        // visit all points in order
        for (int[] h : height) {
            if (h[1] < 0) { // a start point, add height
                pq.offer(-h[1]);
            } else {  // a end point, remove height
                pq.remove(h[1]);
            }
            int cur = pq.peek(); // current max height;

            // compare current max height with previous max height, update result and
            // previous max height if necessary
            if (prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;
    }

    /**
     * Memory limit exceeded
     *
     * @param buildings
     * @return
     */
    public static List<int[]> getSkylineMLE(int[][] buildings) {

        int rowMax = 0;
        int heightMax = 0;

        for (int i = 0; i < buildings.length; i++) {
            rowMax = Math.max(rowMax, buildings[i][1]);
            heightMax = Math.max(heightMax, buildings[i][2]);
        }

        boolean[][] dmap = new boolean[rowMax][heightMax];

        for (int i = 0; i < buildings.length; i++) {
            int buildingStart = buildings[i][0];
            int buildingEnd = buildings[i][1];
            int buildingHeight = buildings[i][2];
            for (int m = buildingStart; m < buildingEnd; m++) {
                for (int n = 0; n < buildingHeight - 1; n++) {
                    dmap[m][n] = true;
                }
            }
        }

        List<int[]> result = new ArrayList<>();
        boolean isNotfirst = true;
        int prevHeight = 0;
        for (int i = 0; i < dmap.length; i++) {
            if (dmap[i][0] == true) {
                isNotfirst = false;
                int j = 0;
                while (j < heightMax && dmap[i][j] == true) {
                    j++;
                }

                if (prevHeight < j) {
                    int[] point = {i, j + 1};
                    result.add(point);
                } else if (prevHeight > j) {
                    int[] point = {i, j + 1};
                    result.add(point);
                }
                prevHeight = j;
            } else if (!isNotfirst && prevHeight != 0) {
                prevHeight = 0;
                int[] point = {i, 0};
                result.add(point);
            }
            if (i == dmap.length - 1) {
                int[] point = {i + 1, 0};
                result.add(point);
            }
        }

        return result;
    }
}
