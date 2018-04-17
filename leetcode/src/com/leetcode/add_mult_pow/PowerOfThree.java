package com.leetcode.add_mult_pow;

/**
Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
*/
public class PowerOfThree {
	/**
	 * Leetcode verified
	 * @param n
	 * @return
	 */
	public boolean isPowerOfThree(int n) {
		if (n < 1) {
			return false;
		}

		while (n % 3 == 0) {
			n /= 3;
		}

		return n == 1;
	}
}
