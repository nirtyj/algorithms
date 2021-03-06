package com.leetcode.sliding_window;

import java.util.LinkedHashMap;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * <p>
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinSizeSubarraySum_LC209 {

    /**
     * Leetcode verified
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int begin = 0, sum = 0, min = Integer.MAX_VALUE;
        for (int end = 0; end < nums.length; end++) {
            sum = sum + nums[end];
            while (sum >= target) {
                min = Math.min(min, end - begin + 1);
                sum = sum - nums[begin];
                begin++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    /**
     * Time limit exceeded
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLenTLE(int s, int[] nums) {
        LinkedHashMap<Integer, Integer> sumToPos = new LinkedHashMap<>();
        int sum = 0;
        int previousIndex = -1;
        int minLength = Integer.MAX_VALUE;
        int minSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (i == 0)
                minSum = sum;
            if (sum >= s) {
                int key = sum - s;
                while (key >= minSum) {
                    if (sumToPos.containsKey(key)) {
                        previousIndex = Math.max(previousIndex, sumToPos.get(key));
                        break;
                    }
                    key--;
                }

                minLength = Math.min(minLength, i - previousIndex);
            }
            sumToPos.put(sum, i);
        }
        if (minLength == Integer.MAX_VALUE)
            return 0;
        return minLength;
    }
}
