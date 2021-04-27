package com.leetcode.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * <p>
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * <p>
 * You should return the indices: [0,9].
 * (order does not matter).
 */
public class SubstringWithConcatenationOfAllWords_LC30 {

    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new LinkedList<>();
        if (L.length == 0 || S.length() < L.length * L[0].length())
            return res;
        int lengthOfOneWord = L[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (String s : L) {
            if (map.containsKey(s))
                map.put(s, map.get(s) + 1);
            else
                map.put(s, 1);
        }
        for (int i = 0; i < lengthOfOneWord; i++) {
            // do sliding window for different start points until the end of the string.
            doSlidingWindow(S, L, res, lengthOfOneWord, map, i);
        }
        return res;
    }

    private void doSlidingWindow(String S, String[] L, List<Integer> res, int lengthOfOneWord, Map<String, Integer> map,
                                 int startPosition) {
        int counter = 0;
        int begin = startPosition;
        Map<String, Integer> seen = new HashMap<>();
        for (int end = startPosition; end + lengthOfOneWord <= S.length(); end += lengthOfOneWord) {
            String str = S.substring(end, end + lengthOfOneWord);
            // if the map doesnt contain the string, update the start to that word.
            if (map.containsKey(str)) {
                // if the map contains the string, then do sliding window with counts
                if (seen.containsKey(str))
                    seen.put(str, seen.get(str) + 1);
                else
                    seen.put(str, 1);

                if (seen.get(str) <= map.get(str))
                    counter++;

                // its good as long as the count is less. if its higher, try to move the begin when the condition satisfies
                while (seen.get(str) > map.get(str)) {
                    String beginWord = S.substring(begin, begin + lengthOfOneWord);
                    seen.put(beginWord, seen.get(beginWord) - 1);
                    begin += lengthOfOneWord;

                    // the same as https://leetcode.com/problems/longest-substring-without-repeating-characters/
                    if (seen.get(beginWord) < map.get(beginWord))
                        counter--;

                }
                if (counter == L.length) { // count is satisfied, then add the result
                    res.add(begin);
                    String beginWord = S.substring(begin, begin + lengthOfOneWord);
                    seen.put(beginWord, seen.get(beginWord) - 1); // update the begin word to find next matches.
                    begin += lengthOfOneWord;
                    counter--;
                }
            } else {
                seen.clear();
                counter = 0;
                begin = end + lengthOfOneWord;// not contain, so move the start
            }
        }
    }

    /**
     * naive but readable
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstringReadable(String s, String[] words) {
        if (s == null || words == null || s.length() == 0 || words.length == 0) {
            return new ArrayList<>();
        }
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        List<Integer> r = new ArrayList<>();
        int sLen = s.length();
        int num = words.length;
        int wordLen = words[0].length();
        for (int i = 0; i < sLen - num * wordLen + 1; i++) {
            String sub = s.substring(i, i + num * wordLen);
            if (isConcat(sub, counts, wordLen)) {
                r.add(i);
            }
        }
        return r;
    }

    private boolean isConcat(String sub, Map<String, Integer> counts, int wordLen) {
        Map<String, Integer> seen = new HashMap<>();
        for (int i = 0; i < sub.length(); i += wordLen) {
            String sWord = sub.substring(i, i + wordLen);
            seen.put(sWord, seen.getOrDefault(sWord, 0) + 1);
            if (!counts.containsKey(sWord) || seen.get(sWord) > counts.getOrDefault(sWord, 0)) {
                return false;
            }
        }
        return seen.equals(counts);
    }
}
