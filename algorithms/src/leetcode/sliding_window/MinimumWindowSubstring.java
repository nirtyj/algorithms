package leetcode.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/
public class MinimumWindowSubstring {
	
	/**
	 * Leetcode verified
	 * @param s
	 * @param t
	 * @return
	 */
	public String minWindow(String s, String t) {
		if (t.length() > s.length())
			return "";
		Map<Character, Integer> map = new HashMap<>();
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int counter = map.size();

		int begin = 0, end = 0;
		int head = 0;
		int len = Integer.MAX_VALUE;

		while (end < s.length()) {
			char c = s.charAt(end);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
				if (map.get(c) == 0)
					counter--;
			}
			end++;

			while (counter == 0) {
				char tempc = s.charAt(begin);
				if (map.containsKey(tempc)) {
					map.put(tempc, map.get(tempc) + 1);
					if (map.get(tempc) > 0) {
						counter++;
					}
				}
				if (end - begin < len) {
					len = end - begin;
					head = begin;
				}
				begin++;
			}

		}
		if (len == Integer.MAX_VALUE)
			return "";
		return s.substring(head, head + len);
	}
}
