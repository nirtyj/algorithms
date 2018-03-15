package com.leetcode.easy;

/**
Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.
*/
public class SumOfTwoIntegers {

	/**
	 * Leetcode verified
	 * @param a
	 * @param b
	 * @return
	 * 
	 * a+b = (a XOR b) + (a AND b)*2 is << 1
	 */
	public static int getSum(int a, int b) {

		while (b != 0) {
			// carry bit
			int c = a & b;
			a = a ^ b;
			b = c << 1;
		}

		return a;
	}
}
