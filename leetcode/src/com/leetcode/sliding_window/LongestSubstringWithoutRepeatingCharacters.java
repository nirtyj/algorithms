package com.leetcode.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
Given a string, find the length of the longest substring without repeating characters.

Examples:


Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
public class LongestSubstringWithoutRepeatingCharacters {

	/**
	 * Leetcode verified
	 * 
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstringMine(String s) {
		if (s == null || s.length() == 0)
			return 0;
		if (s.length() == 1)
			return 1;

		int i = 0;
		int maxLength = 1;
		HashMap<Character, Integer> chars = new HashMap<>();
		chars.put(s.charAt(i), 0);
		for (int j = 1; j < s.length(); j++) {
			// if there is already a character seen, move i to that position + 1
			// also make sure, you dont go back on the i. hence the max of current i vs the
			// next i
			// next i should always be higher than the current
			if (chars.containsKey(s.charAt(j))) {
				i = Math.max(i, chars.get(s.charAt(j)) + 1);
			}

			// put the current char
			chars.put(s.charAt(j), j);

			// find the max length
			maxLength = Math.max(maxLength, j - i + 1);
		}
		return maxLength;
	}

	public static int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int begin = 0, end = 0, counter = 0, d = 0;

		while (end < s.length()) {
			// > 0 means repeating character
			// if(map[s.charAt(end++)]-- > 0) counter++;
			char c = s.charAt(end);
			map.put(c, map.getOrDefault(c, 0) + 1);
			if (map.get(c) > 1)
				counter++;
			end++;

			while (counter > 0) {
				// if (map[s.charAt(begin++)]-- > 1) counter--;
				char charTemp = s.charAt(begin);
				if (map.get(charTemp) > 1)
					counter--;
				map.put(charTemp, map.get(charTemp) - 1);
				begin++;
			}
			d = Math.max(d, end - begin);
		}
		return d;
	}

}
