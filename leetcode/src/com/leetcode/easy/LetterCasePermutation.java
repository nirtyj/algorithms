package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
/**
Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
Note:

S will be a string with length at most 12.
S will consist only of letters or digits.
*/
public class LetterCasePermutation {

	/**
	 * Leetcode verified
	 */
	List<String> result = null;
	public List<String> letterCasePermutation(String S) {
		result = new ArrayList<>();
		recurseHelper(0, "", S);
		return result;
	}

	public void recurseHelper(int index, String curr, String S) {
		if (index == S.length()) {
			result.add(curr);
			return;
		}
		if (S.charAt(index) >= 97 && S.charAt(index) <= 122) {
			recurseHelper(index + 1, curr + Character.toUpperCase(S.charAt(index)), S);
		} else if (S.charAt(index) >= 65 && S.charAt(index) <= 90) {
			recurseHelper(index + 1, curr + Character.toLowerCase(S.charAt(index)), S);
		}
		recurseHelper(index + 1, curr + S.charAt(index), S);
	}
}
