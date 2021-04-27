package com.leetcode.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string that consists of only uppercase English letters, you can replace any letter in the string with another letter at most k times.
 * Find the length of a longest substring containing all repeating letters you can get after performing the above operations.
 * <p>
 * Note:
 * Both the string's length and k will not exceed 104.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s = "ABAB", k = 2
 * <p>
 * Output:
 * 4
 * <p>
 * Explanation:
 * Replace the two 'A's with two 'B's or vice versa.
 * Example 2:
 * <p>
 * Input:
 * s = "AABABBA", k = 1
 * <p>
 * Output:
 * 4
 * <p>
 * Explanation:
 * Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 */
public class LongestRepeatingCharacterReplacement_LC424 {

    public int characterReplacement(String s, int k) {
        if (s == null || s.isEmpty()) return 0;
        int begin = 0, counter = 0, result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            counter = Math.max(counter, map.get(ch));

            // check how many chars to "flip" by looking at the delta between the
            // length of the string and the highest frequency char. If <= k, no problem. Otherwise, move window
            while((end - begin + 1 - counter) > k) { // apply De Morgan and make it right - left + 1 - counter > k
                char tmp = s.charAt(begin);
                map.put(tmp, map.get(tmp) - 1);
                begin++;
            }
            result = Math.max(result, end - begin + 1);
        }
        return result;
    }
}
