package com.leetcode.easy;

/**
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
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
