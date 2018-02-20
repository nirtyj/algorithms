package leetcode.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

For example, Given s = “eceba”,
T is "ece" which its length is 3.
*/
public class LongestSubstringWithAtMostTwoDisticntChars {

	/**
	 * Leetcode verified
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int start = 0, end = 0, counter = 0, len = 0;
		while (end < s.length()) {
			char c = s.charAt(end);
			map.put(c, map.getOrDefault(c, 0) + 1);
			if (map.get(c) == 1)
				counter++;// new char
			end++;
			while (counter > 2) {
				char cTemp = s.charAt(start);
				map.put(cTemp, map.get(cTemp) - 1);
				if (map.get(cTemp) == 0) {
					counter--;
				}
				start++;
			}
			len = Math.max(len, end - start);
		}
		return len;
	}
}
