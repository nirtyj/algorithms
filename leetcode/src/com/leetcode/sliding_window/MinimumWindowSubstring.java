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
public class MinimumWindowSubstring {

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
        int end = 0;
        int minLength = Integer.MAX_VALUE;
        int head = 0;
        while (end < s.length()) {

            char c = s.charAt(end);
            if (map.containsKey(c)) {
                int hitCounter = map.get(c);
                hitCounter--;
                map.put(c, hitCounter);
                if (map.get(c) == 0) {
                    counter--;
                }
            }
            end++;
            while (counter == 0) {
                char beginC = s.charAt(begin);
                if (map.containsKey(beginC)) {
                    int hitCounter = map.get(beginC);
                    hitCounter++;
                    map.put(beginC, hitCounter);
                    if (map.get(beginC) > 0) {
                        counter++;
                    }
                }

                if (end - begin < minLength) {
                    minLength = end - begin;
                    head = begin;
                }
                begin++;
            }
        }

        if (minLength == Integer.MAX_VALUE)
            return "";
        return s.substring(head, head + minLength);

    }
}
