package com.leetcode.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
Given a string that consists of only uppercase English letters, you can replace any letter in the string with another letter at most k times. Find the length of a longest substring containing all repeating letters you can get after performing the above operations.

Note:
Both the string's length and k will not exceed 104.

Example 1:

Input:
s = "ABAB", k = 2

Output:
4

Explanation:
Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input:
s = "AABABBA", k = 1

Output:
4

Explanation:
Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
*/
public class LongestRepeatingCharacterReplacement {
	public int characterReplacement(String s, int k) {
		if (s == null || s.isEmpty())
			return 0;
		int left = 0, right = 0, counter = 0, res = 0;
		Map<Character, Integer> map = new HashMap<>();
		while (right < s.length()) {
			char ch = s.charAt(right++);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			if (counter < map.get(ch))
				counter = map.get(ch);
			// check how many chars to "flip" by looking at the delta between the
			// length of the string and the highest frequency char. If <= k, no problem.
			// Otherwise, move window
			while (!(right - left - counter <= k)) { // apply De Morgan and make it right - left - counter > k
				char tmp = s.charAt(left);
				map.put(tmp, map.get(tmp) - 1);
				counter = getMax(map);
				left++;
			}
			res = Math.max(res, right - left);
		}
		return res;
	}

	private int getMax(Map<Character, Integer> map) {
		int max = 0;
		for (int freq : map.values()) {
			max = Math.max(max, freq);
		}
		return max;
	}
}
