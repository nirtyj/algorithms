package com.leetcode.binarysearch;

/**
 * An ugly number is a positive integer that is divisible by a, b, or c.
 *
 * Given four integers n, a, b, and c, return the nth ugly number.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3, a = 2, b = 3, c = 5
 * Output: 4
 * Explanation: The ugly numbers are 2, 3, 4, 5, 6, 8, 9, 10... The 3rd is 4.
 * Example 2:
 *
 * Input: n = 4, a = 2, b = 3, c = 4
 * Output: 6
 * Explanation: The ugly numbers are 2, 3, 4, 6, 8, 9, 10, 12... The 4th is 6.
 * Example 3:
 *
 * Input: n = 5, a = 2, b = 11, c = 13
 * Output: 10
 * Explanation: The ugly numbers are 2, 4, 6, 8, 10, 11, 12, 13... The 5th is 10.
 */
public class UglyNumberIII_LC1201 {

    /**
     * Use set theory formula to find the number of numbers divisible by a or b or c.
     * find the number of numbers divisible by a within x, use LCM
     *
     * Euclidean Theorem for the greatest common denominator,
     * then using a variation of lcm to do subsets.
     *
     * All just to get the place from the VALUE, in order to do binary search.
     * @param n
     * @param b
     * @param c
     * @param a
     * @return
     */
    public int nthUglyNumber(int n,  int b, int c, int a) {
        int left = 0;
        int right = (int) 2e9; //  2*10^9
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (count(mid, a, b, c) >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    int count(long num,  long b, long c, long a) {
        // n(A U B U C) = n(A) + n(B) + n(C) - n(A U B) - n(A U C) - n(B U C) + n(A U B U C)
        return (int) (num / a + num / b + num / c
                - num / lcm(a, b)
                - num / lcm(b, c)
                - num / lcm(a, c)
                + num / (lcm(a, lcm(b, c))));
    }

    long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    long lcm (long a, long b){
        return a * b / gcd(a , b);
    }
}

