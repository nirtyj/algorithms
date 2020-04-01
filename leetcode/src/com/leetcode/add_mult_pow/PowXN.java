package com.leetcode.add_mult_pow;

/**
 * Implement pow(x, n).
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 * <p>
 * Input: 2.10000, 3
 * Output: 9.26100
 */
public class PowXN {
    /**
     * Leetcode verified
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {

        if (n == 0)
            return 1.0;

        double half = myPow(x, n / 2);
        if (n % 2 == 0)
            return half * half;
        else {
            if (n > 0) {
                return half * half * x;
            } else {
                return (half * half) / x;
            }
        }

    }
}
