package com.leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].
 *
 * A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction,
 * then one square in an orthogonal direction.
 *
 *
 *
 * Return the minimum number of steps needed to move the knight to the square [x, y].
 * It is guaranteed the answer exists.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 2, y = 1
 * Output: 1
 * Explanation: [0, 0] → [2, 1]
 * Example 2:
 *
 * Input: x = 5, y = 5
 * Output: 4
 * Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
 */
public class MinimumKnightMoves {

    int[][] possibleMoves = new int[][] {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};

    // Map everything to 1st quadrant and avoid apposite quadrants except -1 position.
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        Queue<int[]> nextMoves = new LinkedList<>();
        nextMoves.add(new int[]{0 , 0});
        Set<String> visited = new HashSet<>();
        visited.add("0,0");
        int result = 0;
        while(!nextMoves.isEmpty()) {
            int size = nextMoves.size();
            for (int i=0;i<size;i++) {
                int[] move = nextMoves.poll();
                if (move[0] == x && move[1] == y) {
                    return result;
                }
                for (int[] direction : possibleMoves) {
                    int nextX = move[0] + direction[0];
                    int nextY = move[1] + direction[1];
                    if (!visited.contains(nextX+","+nextY) && nextX >= -1 && nextY >=-1) {
                        nextMoves.offer(new int[]{nextX, nextY});
                        visited.add(nextX+","+nextY);
                    }
                }
            }
            result++;
        }
        return result;
    }

    /**
     * Slower but takes out only half of unwanted quadrants
     * @param x
     * @param y
     * @return
     */
    public int minKnightMovesCutOffOtherHalfQuadrants(int x, int y) {
        if (x ==0 && y ==0) {
            return 0;
        }
        Queue<int[]> nextMoves = new LinkedList<>();
        nextMoves.add(new int[]{0 , 0, 0});
        int result = -1;
        int[] finalMove = null;
        Set<String> visited = new HashSet<>();
        visited.add("0,0");
        while(!nextMoves.isEmpty()) {
            int[] move = nextMoves.poll();
            for (int[] direction : possibleMoves) {
                int nextX = move[0] + direction[0];
                int nextY = move[1] + direction[1];
                if (nextX == x && nextY ==y) {
                    finalMove = move;
                    break;
                } else {
                    if (visited.contains(nextX+","+nextY)) {
                        continue;
                    } else if (x > 0 && nextX <0 || x <0 && nextX >0) {
                        continue;
                    } else {
                        nextMoves.offer(new int[]{nextX , nextY, move[2] + 1});
                        visited.add(nextX+","+nextY);
                    }
                }
            }
            if (finalMove != null) {
                result = finalMove[2] + 1;
                break;
            }
        }
        return result;
    }
}
