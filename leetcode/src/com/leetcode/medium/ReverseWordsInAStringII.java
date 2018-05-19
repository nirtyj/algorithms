package com.leetcode.medium;
/**
Given an input string , reverse the string word by word. 

Example:

Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
Note: 

A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces.
The words are always separated by a single space.
*/
public class ReverseWordsInAStringII {

	/**
	 * Leetcode verified
	 * @param str
	 */
	public void reverseWords(char[] str) {
		if (str == null || str.length <= 1)
			return;
		reverse(str, 0, str.length - 1);
		for (int i = 0; i < str.length;) {
			if (str[i] == ' ')
				i++;
			else {
				int start = i;
				while (i < str.length && str[i] != ' ')
					i++;
				reverse(str, start, i - 1);
			}
		}
	}

	void reverse(char[] str, int i, int j) {
		while (i < j) {
			char temp = str[i];
			str[i] = str[j];
			str[j] = temp;
			i++;
			j--;
		}
	}
}
