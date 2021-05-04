package com.leetcode.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a string containing only 4 kinds of characters 'Q', 'W', 'E' and 'R'.
 *
 * A string is said to be balanced if each of its characters appears n/4 times where n is the length of the string.
 *
 * Return the minimum length of the substring that can be replaced with any other string of the same length to make the original string s balanced.
 *
 * Return 0 if the string is already balanced.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "QWER"
 * Output: 0
 * Explanation: s is already balanced.
 * Example 2:
 *
 * Input: s = "QQWE"
 * Output: 1
 * Explanation: We need to replace a 'Q' to 'R', so that "RQWE" (or "QRWE") is balanced.
 * Example 3:
 *
 * Input: s = "QQQW"
 * Output: 2
 * Explanation: We can replace the first "QQ" to "ER".
 * Example 4:
 *
 * Input: s = "QQQQ"
 * Output: 3
 * Explanation: We can replace the last 3 'Q' to make s = "QWER".
 */
public class ReplaceTheSubstringForBalancedString_LC1234 {

    /**
     * Inverse Sliding Window - As long as the criteria satisfies outside of the sliding window that is your result.
     * "we don't care the count of elements inside the window, we want to know the count outside the window"
     * https://leetcode.com/problems/replace-the-substring-for-balanced-string/discuss/408978/JavaC%2B%2BPython-Sliding-Window
     * @param s
     * @return
     */
    public int balancedString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('Q', 0);
        map.put('W', 0);
        map.put('E', 0);
        map.put('R', 0);
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int begin = 0;
        int result = Integer.MAX_VALUE;
        int desired = s.length() / 4;
        for (int end = 0; end < s.length(); end++) {
            map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
            while (begin < s.length() && map.get('Q') <= desired && map.get('W') <= desired && map.get('E') <= desired && map.get('R') <= desired) {
                result = Math.min(result, end - begin + 1);
                map.put(s.charAt(begin), map.get(s.charAt(begin)) + 1);
                begin++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
