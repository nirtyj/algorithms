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
public class SquareRoot_LC69 {

    /**
     * leetcode verified
     * First we need to search for minimal k satisfying condition k^2 > x, then k - 1 is the answer to the question
     * @param input
     * @return
     */
    public int mySqrt(int input) {
        if (input == 0){
            return 0;
        } else if (input == 1){
            return 1;
        }
        long left = 0;
        long right = input;
        right = right + 1; // include the search space
        while (left < right) {
            long middle = left + (right - left) / 2;
            if (middle * middle > input) {
                right = middle;
            }
            else  {
                left = middle + 1;
            }
        }
        return (int) (left - 1);
    }
}
