package com.leetcode.graph.ShortestAndLongestPath;

import java.util.PriorityQueue;

/**
 * Given a matrix of integers A with R rows and C columns, find the maximum score of a path starting at [0,0] and ending at [R-1,C-1].
 *
 * The score of a path is the minimum value in that path.  For example, the value of the path 8 →  4 →  5 →  9 is 4.
 *
 * A path moves some number of times from one visited cell to any neighbouring unvisited cell in one of the 4 cardinal directions (north, east, west, south).
 */
public class PathWithMaximumMinimumValue_LC1102 {


    static int[][] directions = {{-1, 0}, {+1, 0}, {0, -1}, {0, +1}};

    /**
     * BFS Dijkstra ! - Queue with int[] as objects to hold
     * @param A
     * @return
     */
    public int maximumMinimumPath(int[][] A) {
        // next val, x, y
        PriorityQueue<int[]> nextQ = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        nextQ.add(new int[] {A[0][0], 0, 0});
        int score = A[0][0];
        A[0][0] = -1;
        while(!nextQ.isEmpty()){
            int[] next = nextQ.poll();
            int x = next[1];
            int y = next[2];
            score = Math.min(score, next[0]);
            if (x == A.length-1 && y== A[0].length -1) {
                break;
            }
            for(int[] dir : directions){
                if (dir[0] + x >= 0 && dir[0] + x < A.length && dir[1] + y >= 0 && dir[1] + y < A[0].length
                        && A[dir[0] + x][dir[1] + y] != -1){
                    nextQ.add(new int[]{A[dir[0] + x][dir[1] + y], dir[0] + x, dir[1] + y});
                    A[dir[0] + x][dir[1] + y] = -1;
                }
            }
        }
        return score;
    }

}
