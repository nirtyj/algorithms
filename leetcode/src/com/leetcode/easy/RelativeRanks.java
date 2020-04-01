package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 * <p>
 * Example 1:
 * Input: [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
 * For the left two athletes, you just need to output their relative ranks according to their scores.
 * Note:
 * N is a positive integer and won't exceed 10,000.
 * All the scores of athletes are guaranteed to be unique.
 */
public class RelativeRanks {

    /**
     * Leetcode verified
     *
     * @param nums
     * @return
     */
    public String[] findRelativeRanks(int[] nums) {
        List<PositionScore> result = new ArrayList<PositionScore>();
        for (int i = 0; i < nums.length; i++) {
            result.add(new PositionScore(nums[i], i));
        }
        Collections.sort(result);
        String[] res = new String[nums.length];
        for (int i = 0; i < result.size(); i++) {
            PositionScore m = result.get(i);
            if (i == 0) {
                res[m.pos] = "Gold Medal";
            } else if (i == 1) {
                res[m.pos] = "Silver Medal";
            } else if (i == 2) {
                res[m.pos] = "Bronze Medal";
            } else {
                res[m.pos] = Integer.toString(i + 1);
            }
        }
        return res;
    }

    class PositionScore implements Comparable<PositionScore> {
        Integer score;
        Integer pos;

        PositionScore(Integer score, Integer pos) {
            this.score = score;
            this.pos = pos;
        }

        public int compareTo(PositionScore other) {
            return -Integer.compare(score, other.score);
        }
    }
}
