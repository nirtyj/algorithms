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
	public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		int begin = 0;
		int end = 0;
		int maxLength = 0;
		int counter = 0;
		while (end < s.length()) {
			char c = s.charAt(end);
			map.put(c, map.getOrDefault(c, 0) + 1);
			// one char which is unique. size is 1
			if (map.get(c) > 1)
				counter++;
			end++;

			while (counter > 0) {
				char beginC = s.charAt(begin);
				if (map.containsKey(beginC)) {
					// decrement counter as long as its greater than 1
					if (map.get(beginC) > 1) {
						counter--;
					}
					map.put(beginC, map.get(beginC) - 1);
				}
				begin++;
			}
			// update max
			maxLength = Math.max(end - begin, maxLength);
		}

		return maxLength;
	}
}
