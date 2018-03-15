package com.leetcode.easy;

/**
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
Given two integers x and y, calculate the Hamming distance.
Note:
0 ≤ x, y < 231.

Example:
Input: x = 1, y = 4

Output: 2
Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.
*/
public class HammingDistance {

	/**
	 * Leetcode verified
	 * Hamming distance between 2 integers XOR gives different bits. Count them
	 * @param a
	 * @param b
	 * @return
	 */
	public int countDigitsToMake(int a, int b) {
		// XOR gives the bits that are different
		int c = a ^ b;
		int digits = 0;
		// count the number of bits
		while (c != 0) {
			digits++;
			// its more like decimal = decimal / 10
			// remove the last digit from the number.
			c = c & (c - 1);
		}
		return digits;
	}

}
