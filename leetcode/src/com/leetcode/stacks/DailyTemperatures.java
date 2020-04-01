package com.leetcode.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a list of daily temperatures, produce a list that, for each day in the input, tells you how many days you would have to wait until a warmer temperature.
 * If there is no future day for which this is possible, put 0 instead.
 * <p>
 * For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * <p>
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */
public class DailyTemperatures {
    /**
     * Leetcode verified
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[0];
        }
        int[] result = new int[temperatures.length];
        Deque<int[]> stack = new ArrayDeque<int[]>(temperatures.length);
        stack.push(new int[]{0, temperatures[0]});
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > stack.peek()[1]) {
                int[] p = stack.pop();
                result[p[0]] = i - p[0];
            }
            stack.push(new int[]{i, temperatures[i]});
        }
        while (!stack.isEmpty()) {
            int[] p = stack.pop();
            result[p[0]] = 0;
        }
        return result;
    }
}
