package com.leetcode.sliding_window;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
 * <p>
 * For example, Given s = “eceba”,
 * T is "ece" which its length is 3.
 */
public class LongestSubstringWithAtMostTwoDistinctChars_LC159 {

    /**
     * Leetcode verified
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int begin = 0;
        int maxLength = 0;
        int counter = 0;
        int k = 2;
        for (int end = 0 ; end < s.length(); end++) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == 1)
                counter++;

            while (counter > k) {
                char beginC = s.charAt(begin);
                map.put(beginC, map.get(beginC) - 1);
                if (map.get(beginC) == 0) {
                    counter--;
                }
                begin++;
            }
            // update max
            maxLength = Math.max(end - begin + 1, maxLength);
        }
        return maxLength;
    }
}
