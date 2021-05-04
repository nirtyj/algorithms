package com.leetcode.sliding_window;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * ou are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 */
public class SlidingWindowMaximum_LC239 {

    /**
     * Monotonically increasing subarray using deque
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int v = 0;
        int resultArr[] = new int[nums.length - k + 1];
        Deque<Integer> queue = new ArrayDeque<>(); // stores the index
        for (int end = 0; end < nums.length; end++) {
            // keeps only k elements in the deque
            while (!queue.isEmpty() && queue.peek() < end - k + 1) {
                queue.poll();
            }

            // removes smaller elements to keep a monotonically increasing subarray
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[end]) {
                queue.pollLast();
            }
            queue.addLast(end);
            if (end + 1 >= k ){ // check only after k elements are looked at.
                resultArr[v++] = nums[queue.peek()];
            }
        }
        return resultArr;
    }


    /**
     * Timelimit exceeded because of priority Queue
     */
    public int[] maxSlidingWindowNaive(int[] nums, int k) {
        int begin = 0;
        int v = 0;
        int resultArr[] = new int[nums.length - k + 1];
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int end = 0; end < nums.length; end++) {
            pQueue.add(nums[end]);
            while (end - begin + 1 > k && begin < end) {
                pQueue.remove(nums[begin]);
                begin++;
            }
            if (end - begin + 1 == k) {
                resultArr[v++] = pQueue.peek();
            }
        }
        return resultArr;
    }
}
