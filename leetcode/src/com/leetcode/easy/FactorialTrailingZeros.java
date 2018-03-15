package com.leetcode.easy;

/**
Given an integer n, return the number of trailing zeroes in n!.
Note: Your solution should be in logarithmic time complexity.
*/
public class FactorialTrailingZeros {
	
	/**
	 * Leetcode verified
	 * @param n
	 * @return
	 */
    public int trailingZeroes(int n) {
    		// count how many 2*5's are there. so its enough to count number of 5's as 2 is included in it
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);   
    }
}
