package com.leetcode.sliding_window;

import java.util.HashMap;

/**
Given a string, find the length of the longest substring T that contains at most k distinct characters.

For example, Given s = “eceba” and k = 2,

T is "ece" which its length is 3.
*/
public class LongstSubstringWithAtMostKDistinctCharacters {

	/**
	 * Leetcode verified
	 * @param s
	 * @param k
	 * @return
	 */
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		HashMap<Character, Integer> map = new HashMap<>();
		int begin = 0;
		int end = 0;
		int maxLength = 0;
		int counter = 0;
		while (end < s.length()) {
			char c = s.charAt(end++);
			map.put(c, map.getOrDefault(c, 0) + 1);
			if (map.get(c) == 1)
				counter++;

			while (counter > k) {
				char beginC = s.charAt(begin);
				map.put(beginC, map.get(beginC) - 1);
				if (map.get(beginC) == 0) {
					counter--;
				}
				begin++;
			}
			// update max
			maxLength = Math.max(end - begin, maxLength);
		}

		return maxLength;
	}
}
