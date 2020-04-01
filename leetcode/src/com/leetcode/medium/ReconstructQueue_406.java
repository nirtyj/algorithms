package com.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 406. https://leetcode.com/problems/queue-reconstruction-by-height/description/
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 * <p>
 * Note:
 * The number of people is less than 1,100.
 * <p>
 * Example
 * <p>
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * <p>
 * subarray after step 1: [[7,0], [7,1], [6,1], [5,0], [5,2], [4, 4]]
 * subarray after step 2: [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class ReconstructQueue_406 {

    /**
     * Leetcode verified
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        // sort by descending height. if height are same, increasing people infront.
        Arrays.sort(people, (p1, p2) -> {
            return p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0];
        });
        // insert the location from front. so 0 people in front goes front.
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < people.length; i++)
            list.add(people[i][1], people[i]);

        return list.toArray(people);
    }
}
