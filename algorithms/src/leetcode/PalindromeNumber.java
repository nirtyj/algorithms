package leetcode;

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

		// MSB mask
		int div = 1;
		while (num / div > 10) {
			div = div * 10;
		}

		while (num != 0) {
			int msb = num / div;
			int lsb = num % 10;
			if (lsb != msb)
				return false;
			num = (num % div) / 10;
			div = div / 100;
		}
		return true;
	}

	/**
	 * Uses division and modulus to calculate if its palindrome
	 * 
	 * @param num
	 * @return
	 */
	public boolean isPalindromeMath(int num) {
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
