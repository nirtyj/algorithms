package com.leetcode.easy;

/**
https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.
*/
public class ReverseWordsInAString_557 {
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
		for (int i = 0; i < s.length();) {
			if (s.charAt(i) != ' ') {
				tempsb = new StringBuilder();
				while (i < s.length() && s.charAt(i) != ' ') {
					tempsb.append(s.charAt(i));
					i++;
				}
				sb.append(tempsb.reverse().toString());
			} else {
				i++;
				sb.append(' ');
			}
		}
		return sb.toString();
	}
}
