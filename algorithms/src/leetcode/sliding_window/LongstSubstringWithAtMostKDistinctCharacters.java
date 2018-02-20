package leetcode.sliding_window;

import java.util.HashMap;
import java.util.Map;

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
		if (s == null || s.isEmpty())
			return 0;
		int maxLen = 0, left = 0, right = 0, counter = 0;
		Map<Character, Integer> map = new HashMap<>();
		while (right < s.length()) {
			char ch = s.charAt(right++);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			if (map.size() > k)
				counter++;
			while (counter > 0) {
				char tmp = s.charAt(left);
				map.put(tmp, map.get(tmp) - 1);
				if (map.get(tmp) == 0) {
					map.remove(tmp);
					counter--;
				}
				left++;
			}
			maxLen = Math.max(maxLen, right - left);

		}
		return maxLen;
	}
}
