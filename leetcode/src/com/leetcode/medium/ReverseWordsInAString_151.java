package com.leetcode.medium;

/**
151. https://leetcode.com/problems/reverse-words-in-a-string/description/
Given an input string, reverse the string word by word.

Example:  

Input: "the sky is blue",
Output: "blue is sky the".
Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
*/
public class ReverseWordsInAString_151 {

	/**
	 * Leetcode verified
	 * @param s
	 * @return
	 */
	public String reverseWords(String s) {
		if (s == null || s.length() == 0)
			return s;

		s = s.trim();
		StringBuilder sb = new StringBuilder();
		StringBuilder tempsb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0;) {
			if (s.charAt(i) == ' ') {
				while (i >= 0 && s.charAt(i) == ' ')
					i--;
				sb.append(' ');
			} else {
				tempsb = new StringBuilder();
				while (i >= 0 && s.charAt(i) != ' ') {
					tempsb.append(s.charAt(i));
					i--;
				}
				sb.append(tempsb.reverse().toString());
			}
		}
		return sb.toString();
	}
}
