package com.leetcode.binarysearch;

/**
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x.
 * <p>
 * x is guaranteed to be a non-negative integer.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 4
 * Output: 2
 * Example 2:
 * <p>
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will be truncated.
 */
public class SquareRoot {

    /**
     * leetcode verified
     *
     * @param input
     * @return
     */
    public static int findSquareRoot(int input) {
        int left = 0;
        int right = input;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            double squared = (double) middle * middle;
            if (squared == input)
                return middle;
            else if (squared > input)
                right = middle - 1;
            else
                left = middle + 1;
        }
        // return the actual number itself
        return left - 1;
    }

    public static double findSquareRoot(double k) {
        return 0.0;
    }
}
