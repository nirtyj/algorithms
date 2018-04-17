package com.leetcode.add_mult_pow;

/**
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
You may assume the integer do not contain any leading zero, except the number 0 itself.
The digits are stored such that the most significant digit is at the head of the list.
*/
public class PlusOne {

	/**
	 * Leetcode verified
	 * @param digits
	 * @return
	 */
	public int[] plusOne(int[] digits) {

		if (digits == null || digits.length == 0)
			return digits;

		int carry = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int sum = digits[i] + carry;
			int mod = sum % 10;
			digits[i] = mod;
			carry = sum / 10;
		}

		if (carry > 0) {
			int[] copy = new int[digits.length + 1];
			copy[0] = carry;
			for (int i = 0; i < digits.length; i++)
				copy[i + 1] = digits[i];
			return copy;

		}
		return digits;
	}
}
