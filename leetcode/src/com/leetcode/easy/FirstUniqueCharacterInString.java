package com.leetcode.easy;

/**
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:
s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
*/
public class FirstUniqueCharacterInString {

	/**
	 * Leetcode verified
	 * @param s
	 * @return
	 */
	public int firstUniqCharOptimal(String s) {
		int freq[] = new int[26];
		for (int i = 0; i < s.length(); i++)
			freq[s.charAt(i) - 'a']++;
		for (int i = 0; i < s.length(); i++)
			if (freq[s.charAt(i) - 'a'] == 1)
				return i;
		return -1;
	}

	/**
	 * Leetcode verified
	 * @param s
	 * @return
	 */
	public static int firstUniqChar(String s) {
		int[] pos = new int[26];
		for (int i = 0; i < pos.length; i++)
			pos[i] = -1;
		for (int i = 0; i < s.length(); i++) {
			int positioninAl = s.charAt(i) - 'a';
			if (pos[positioninAl] == -1) {
				pos[positioninAl] = i;
			} else {
				pos[positioninAl] = Integer.MIN_VALUE;
			}
		}
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < pos.length; i++) {
			if (pos[i] >= 0) {
				result = Math.min(result, pos[i]);
			}
		}
		if (result == Integer.MAX_VALUE)
			return -1;
		return result;
	}
}
