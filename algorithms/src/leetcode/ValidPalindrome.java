package leetcode;

public class ValidPalindrome {
	/**
	 * Leetcode verified
	 * @param s
	 * @return
	 */
	public boolean isPalindrome(String s) {
		if (s == null || s.isEmpty() || s.length() == 1)
			return true;
		int i = 0;
		int j = s.length() - 1;

		while (i <= j) {
			while (i <= j && !isValidChar(s.charAt(i)))
				i++;

			while (j >= i && !isValidChar(s.charAt(j)))
				j--;

			if (j < i)
				break;

			if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
				return false;

			i++;
			j--;
		}
		return true;
	}

	private boolean isValidChar(char c) {
		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
			return true;
		} else {
			return false;
		}

	}
}
