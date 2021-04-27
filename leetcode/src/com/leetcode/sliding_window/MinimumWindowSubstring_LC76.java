package com.leetcode.sliding_window;

import java.util.HashMap;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * <p>
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * <p>
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring_LC76 {

    /**
     * Leetcode verified
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = map.getOrDefault(t.charAt(i), 0);
            map.put(t.charAt(i), ++count);
        }
        int counter = map.size();
        int begin = 0;
        int minLength = Integer.MAX_VALUE;
        int resultStart = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                int hitCounter = map.get(c);
                map.put(c, --hitCounter);
                if (map.get(c) == 0) {
                    counter--;
                }
            }
            while (counter == 0) {
                char beginC = s.charAt(begin);
                if (map.containsKey(beginC)) {
                    int hitCounter = map.get(beginC);
                    map.put(beginC, ++hitCounter);
                    if (map.get(beginC) > 0) {
                        counter++;
                    }
                }
                if (end - begin + 1 < minLength) {
                    minLength = end - begin + 1;
                    resultStart = begin;
                }
                begin++;
            }
        }
        if (minLength == Integer.MAX_VALUE)
            return "";
        return s.substring(resultStart, resultStart + minLength);
    }
}
