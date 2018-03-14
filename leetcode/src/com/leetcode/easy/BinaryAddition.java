package com.leetcode.easy;

/**
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100"
*/
public class BinaryAddition {

	/**
	 * Leetcode verified
	 * @param a
	 * @param b
	 * @return
	 */
	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;
		// until the length of the binary strings
		while (i >= 0 || j >= 0) {
			int sum = 0;
			if (i >= 0 && a.charAt(i) == '1') {
				sum++;
			}
			if (j >= 0 && b.charAt(j) == '1') {
				sum++;
			}
			sum += carry;
			// if its more than two - may be because of carry
			if (sum >= 2) {
				carry = 1;
			} else {
				carry = 0;
			}
			// mod two as its always 0 or 1
			sb.insert(0, (char) ((sum % 2) + '0'));
			// reduce the index - goes to MSB
			i--;
			j--;
		}
		// finally insert the carry to the beginning of the string
		if (carry == 1)
			sb.insert(0, '1');
		return sb.toString();
	}
}
