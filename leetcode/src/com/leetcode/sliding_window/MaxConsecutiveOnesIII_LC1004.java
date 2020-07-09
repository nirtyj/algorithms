package com.leetcode.sliding_window;

/**
 * Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
 * <p>
 * Return the length of the longest (contiguous) subarray that contains only 1s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * Output: 6
 * Explanation:
 * [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 * Example 2:
 * <p>
 * Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * Output: 10
 * Explanation:
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 */
public class MaxConsecutiveOnesIII_LC1004 {


    /**
     * Leetcode verified O(n)
     * https://leetcode.com/discuss/general-discussion/657507/Sliding-Window-for-Beginners-Problems-or-Template-or-Sample-Solutions
     *
     * @param A
     * @param K
     * @return
     */
    public int longestOnes(int[] A, int K) {
        int i = 0, j = 0;
        int result = Integer.MIN_VALUE;
        for (j = 0; j < A.length; j++) {
            if (A[j] == 0) {
                K--;
            }
            while (K < 0 && i < A.length) { // if also works here
                if (A[i] == 0) {
                    K++;
                }
                i++;
            }
            result = Math.max(result, j - i + 1);
        }
        return result;
    }

    /**
     * Same as this (without while loop)
     */
    public int longestOnesNoWhileLoop(int[] A, int K) {
        int i = 0, j;
        for (j = 0; j < A.length; ++j) {
            if (A[j] == 0) K--;
            if (K < 0 && A[i++] == 0) K++;
        }
        return j - i;
    }
}
