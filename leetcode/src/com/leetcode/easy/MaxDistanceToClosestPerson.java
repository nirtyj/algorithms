package com.leetcode.easy;

/**
 * In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty.
 * There is at least one empty seat, and at least one person sitting.
 * Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
 * Return that maximum distance to closest person.
 *
 * Example 1:
 * Input: [1,0,0,0,1,0,1]
 * Output: 2
 * Explanation:
 * If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
 * If Alex sits in any other open seat, the closest person has distance 1.
 * Thus, the maximum distance to the closest person is 2.
 *
 *  Example 2:
 * Input: [1,0,0,0]
 * Output: 3
 * Explanation:
 * If Alex sits in the last seat, the closest person is 3 seats away.
 * This is the maximum distance possible, so the answer is 3.
 */
public class MaxDistanceToClosestPerson {
    class Solution {
        public int maxDistToClosest(int[] seats) {
            int[] maxSeatDistance = new int[seats.length];
            int max = 0;
            for (int i = 0; i < seats.length; i++) {
                if (i == 0 && seats[i] == 0) {
                    maxSeatDistance[i] = Integer.MAX_VALUE;
                    continue;
                }
                if (seats[i] == 1) {
                    max = 0;
                } else {
                    max++;
                }
                maxSeatDistance[i] = max;
            }
            max = 0;
            for (int i = seats.length - 1; i >= 0; i--) {
                if (i == seats.length - 1 && seats[i] == 0) {
                    maxSeatDistance[i] = Math.min(Integer.MAX_VALUE, maxSeatDistance[i]);
                    continue;
                }
                if (seats[i] == 1) {
                    max = 0;
                } else {
                    max++;
                }
                maxSeatDistance[i] = Math.min(max, maxSeatDistance[i]);
            }
            max = 0;
            for (int i = 0; i < seats.length; i++) {
                max = Math.max(max, maxSeatDistance[i]);
            }
            return max;
        }
    }
}
