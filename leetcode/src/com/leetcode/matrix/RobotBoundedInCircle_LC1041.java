package com.leetcode.matrix;

/**
 * On an infinite plane, a robot initially stands at (0, 0) and faces north.  The robot can receive one of three instructions:
 *
 * "G": go straight 1 unit;
 * "L": turn 90 degrees to the left;
 * "R": turn 90 degress to the right.
 * The robot performs the instructions given in order, and repeats them forever.
 *
 * Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.
 *
 *
 *
 * Example 1:
 *
 * Input: "GGLLGG"
 * Output: true
 * Explanation:
 * The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
 * When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
 */
public class RobotBoundedInCircle_LC1041 {

    public boolean isRobotBounded(String instructions) {
        int[] pos = {0, 0};
        String[] direction = {"up"};
        for (int i = 0; i< instructions.length() ; i++){
            moven(pos, instructions.charAt(i), direction);
        }
        if (pos[0] == 0 && pos[1] ==0) {
            return true;
        }
        if (direction[0] == "up") {
            return false;
        }
        return true;
    }

    private void moven(int[] pos, char dir, String[] direction) {
        if (dir == 'G') {
            if (direction[0] == "up") {
                pos[1] = pos[1] + 1;
            } else if (direction[0] == "down") {
                pos[1] = pos[1] - 1;
            } else if (direction[0] == "left") {
                pos[0] = pos[0] - 1;
            }  else if (direction[0] == "right") {
                pos[0] = pos[0] + 1;
            }
        } else if (dir == 'L') {
            if (direction[0] == "up") {
                direction[0] = "left";
            } else if (direction[0] == "down") {
                direction[0] = "right";
            } else if (direction[0] == "left") {
                direction[0] = "down";
            }  else if (direction[0] == "right") {
                direction[0] = "up";
            }
        } else if (dir == 'R') {
            if (direction[0] == "up") {
                direction[0] = "right";
            } else if (direction[0] == "down") {
                direction[0] = "left";
            } else if (direction[0] == "left") {
                direction[0] = "up";
            }  else if (direction[0] == "right") {
                direction[0] = "down";
            }
        }
    }
}
