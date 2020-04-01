package com.leetcode.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
 * Example 1:
 * Input:s1 = "ab" s2 = "eidbaooo"
 * Output:True
 * <p>
 * Explanation: s2 contains one permutation of s1 ("ba").
 * <p>
 * Example 2:
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 * <p>
 * Note:
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 */
public class PermutationsInAString {

    /**
     * Leetcode verified
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();
        int begin = 0, end = 0;
        while (end < s2.length()) {
            char c = s2.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0)
                    counter--;
            }

            if (counter == 0)
                return true;
            end++;
            if (end - begin == s1.length()) {
                char beginC = s2.charAt(begin);
                if (map.containsKey(beginC)) {
                    map.put(beginC, map.get(beginC) + 1);
                    if (map.get(beginC) == 1) {
                        counter++;
                    }
                }
                begin++;
            }
        }
        return false;
    }
}
