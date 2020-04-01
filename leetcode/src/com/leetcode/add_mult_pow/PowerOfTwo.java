package com.leetcode.add_mult_pow;

/**
 * Given an integer, write a function to determine if it is a power of two.
 */
public class PowerOfTwo {
    /**
     * Leetcode verified
     *
     * @param num
     * @return
     */
    public boolean isPowerOfTwo(int num) {
        return (num > 0) && ((num & (num - 1)) == 0);
    }
}
