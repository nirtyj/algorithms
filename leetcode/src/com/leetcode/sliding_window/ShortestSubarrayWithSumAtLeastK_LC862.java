package com.leetcode.sliding_window;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.
 *
 * If there is no non-empty subarray with sum at least K, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [1], K = 1
 * Output: 1
 * Example 2:
 *
 * Input: A = [1,2], K = 4
 * Output: -1
 * Example 3:
 *
 * Input: A = [2,-1,2], K = 3
 * Output: 3
 */
public class ShortestSubarrayWithSumAtLeastK_LC862 {

    /**
     * Cannot use just sliding window because the negative values will make it inconsistent for the "condition".
     * Hence maintain a monotonic array so that you can use that condition on that array instead of original.
     * https://www.canva.com/design/DADysLyTu_o/view
     * @param A
     * @param K
     * @return
     */
    public int shortestSubarray(int[] A, int K) {
        int result = Integer.MAX_VALUE;
        int[] prefixSum = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + A[i];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int end = 0; end < A.length + 1; end++) {
            // sum of elements in the window begin = deque.getFirst(); end >= K, then keep moving the being until
            // its less than K
            while (deque.size() > 0 && prefixSum[end] - prefixSum[deque.getFirst()] >=  K) {
                result = Math.min(result, end - deque.pollFirst());
                // keep updating the min as long as the sum is higher than K
            }
            // keeps a monotonically increasing index values of A based on prefix sum.
            while (deque.size() > 0 && prefixSum[end] <= prefixSum[deque.getLast()]) {
                // updates it as long as its monotonically not increasing
                deque.pollLast();
            }
            deque.addLast(end);
        }
        return result == Integer.MAX_VALUE ? -1: result;
    }
}
