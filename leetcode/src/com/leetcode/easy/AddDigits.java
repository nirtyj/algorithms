package com.leetcode.easy;

/**
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

Example:

Input: 38
Output: 2 
Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
             Since 2 has only one digit, return it.
*/
public class AddDigits {

	/**
	 * Leetcode verified
	 * @param num
	 * @return
	 */
	public int addDigits(int num) {
		if (num <= 9)
			return num;
		int sum = 0;

		while (num > 0) {
			sum = sum + num % 10;
			num = num / 10;
		}
		return addDigits(sum);
	}

	/**
	 * Congruence formula
	 * @param num
	 * @return
	 */
	public int addDigitsCongruenceFormula(int num) {
		if (num == 0)
			return 0;
		else if (num % 9 == 0)
			return 9;
		return num % 9;
	}
}
