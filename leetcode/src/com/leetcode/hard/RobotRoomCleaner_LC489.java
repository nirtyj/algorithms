package com.leetcode.hard;

import java.util.HashSet;

/**
 * Given a robot cleaner in a room modeled as a grid.
 *
 * Each cell in the grid can be empty or blocked.
 *
 * The robot cleaner with 4 given APIs can move forward, turn left or turn right. Each turn it made is 90 degrees.
 *
 * When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it stays on the current cell.
 *
 * Design an algorithm to clean the entire room using only the 4 given APIs shown below.
 */
public class RobotRoomCleaner_LC489 {
    interface Robot {
        // returns true if next cell is open and robot moves into the cell.
        // returns false if next cell is obstacle and robot stays on the current cell.
        boolean move();

        // Robot will stay on the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        void turnLeft();

        void turnRight();

        // Clean the current cell.
        void clean();
    }

    public final static int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 0: 'up', 1: 'right', 2: 'down', 3: 'left'

    public void cleanRoom(Robot robot) {
        HashSet<String> visited = new HashSet<>();
        backtrack(0, 0, 0, robot, visited);
    }

    public void backtrack(int row, int col, int d, Robot robot, HashSet<String> visited) {
        visited.add(row + "_" + col);
        robot.clean();
        // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
        for (int i = 0; i < 4; ++i) {
            int newD = (d + i) % 4; // always falls in range of 0 to 4.
            int newRow = row + DIRECTIONS[newD][0];
            int newCol = col + DIRECTIONS[newD][1];

            if (!visited.contains(newRow + "_" + newCol) && robot.move()) {
                backtrack(newRow, newCol, newD, robot, visited);
                goBack(robot);
            }
            // turn the robot following chosen direction : clockwise
            robot.turnRight();
        }
    }

    public void goBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}
