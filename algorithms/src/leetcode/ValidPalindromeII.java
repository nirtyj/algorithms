package leetcode;

/**
 * Leetcode verified
 * @author njaganathan
 *
 */
public class ValidPalindromeII {
	public boolean validPalindrome(String s) {
		int l = -1, r = s.length();
		while (++l < --r)
		{
			// when there is a mismatch, see if there is a possibility of a palindrome,
			// after deleting either left char or right char.
			if (s.charAt(l) != s.charAt(r))
				return isPalindromic(s, l, r + 1) || isPalindromic(s, l - 1, r);
		}
		return true;
	}

	public boolean isPalindromic(String s, int l, int r) {
		while (++l < --r)
			if (s.charAt(l) != s.charAt(r))
				return false;
		return true;
	}
}
