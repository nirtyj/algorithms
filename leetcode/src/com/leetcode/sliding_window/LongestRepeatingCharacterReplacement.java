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
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        if (s == null || s.isEmpty())
            return 0;
        int left = 0, right = 0, maxFrequentCharacterVal = 0, res = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char ch = s.charAt(right++);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (maxFrequentCharacterVal < map.get(ch))
                maxFrequentCharacterVal = map.get(ch);
            // find if the number of chars that can be flipped is greater than allowed limit, move window to the right
            // right - left = length of substring - counter(max repeating chars) = no of flippable bits
            while (!(right - left - maxFrequentCharacterVal > k)) {
                char tmp = s.charAt(left);
                map.put(tmp, map.get(tmp) - 1);
                maxFrequentCharacterVal = getMax(map); // update the max to current max frequency
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
