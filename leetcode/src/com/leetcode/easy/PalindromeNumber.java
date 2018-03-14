package com.leetcode.easy;

/**
Determine whether an integer is a palindrome. Do this without extra space.
*/
public class PalindromeNumber {

	/**
	 * Uses division and modulus to calculate if its palindrome
	 * 
	 * @param num
	 * @return
	 */
	public static boolean isPalindrome(int num) {
		if (num < 0)
			return false;
		else if (num == 0)
			return true;

		int NUM_OF_DIGITS = (int) (Math.floor(Math.log10(num))) + 1;
		int MSBMask = (int) Math.pow(10, NUM_OF_DIGITS - 1);

		for (int i = 0; i < (NUM_OF_DIGITS / 2); ++i) {
			if ((num / MSBMask) != (num % 10)) {
				return false;
			}
			num = num % MSBMask; // remove the MSB
			num = num / 10; // remove one char from right
			MSBMask = MSBMask / 100; // need to remove 2 chars for next iteration
		}
		return true;
	}
}
