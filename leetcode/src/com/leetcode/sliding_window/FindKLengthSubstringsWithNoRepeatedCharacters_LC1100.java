package com.leetcode.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S, return the number of substrings of length K with no repeated characters.
 *
 *
 *
 * Example 1:
 *
 * Input: S = "havefunonleetcode", K = 5
 * Output: 6
 * Explanation:
 * There are 6 substrings they are : 'havef','avefu','vefun','efuno','etcod','tcode'.
 */
public class FindKLengthSubstringsWithNoRepeatedCharacters_LC1100 {

    /**
     * Sliding window pattern
     * @param S
     * @param K
     * @return
     */
    public int numKLenSubstrNoRepeats(String S, int K) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int result = 0;
        for (int right = 0; right < S.length(); right++) {
            int freq = map.getOrDefault(S.charAt(right), 0);
            freq++;
            map.put(S.charAt(right), freq);
            if (map.size() == K) {
                result++;
            }
            while (left <= right &&
                    (map.get(S.charAt(right)) > 1 || map.size() == K)) {
                int freqLeft = map.get(S.charAt(left));
                freqLeft--;
                if (freqLeft == 0) {
                    map.remove(S.charAt(left));
                } else {
                    map.put(S.charAt(left), freqLeft);
                }
                left++;
            }
        }
        return result;
    }
}
