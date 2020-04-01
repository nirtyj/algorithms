package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * <p>
 * Example 1:
 * Input: [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Example 2:
 * Input: [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 */
public class SummaryRanges {

    /**
     * Leetcode verified
     *
     * @param nums
     * @return
     */
    public static List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0)
            return Collections.emptyList();
        List<String> result = new ArrayList<String>();
        int start = nums[0];
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - prev != 1) {
                addRange(result, start, prev);
                start = nums[i];
            }
            prev = nums[i];
        }
        addRange(result, start, prev);
        return result;
    }

    private static void addRange(List<String> result, int start, int prev) {
        if (prev == start) {
            result.add(Integer.toString(start));
        } else {
            result.add(start + "->" + prev);
        }
    }
}
