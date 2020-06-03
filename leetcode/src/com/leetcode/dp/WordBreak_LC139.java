package com.leetcode.dp;

import java.util.List;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can
 * be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary
 * does not contain duplicate words.
 * <p>
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * <p>
 * Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak_LC139 {
    /**
     * Leetcode verified
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty())
            return false;

        // one more than the actual size of string
        boolean[] containsArray = new boolean[s.length() + 1];
        containsArray[0] = true;
        // this is upto the length of the string
        for (int i = 0; i < s.length(); i++) {
            if (containsArray[i] == true) {
                // this is less than equals to string length - needed for substring
                for (int j = i + 1; j <= s.length(); j++) {
                    String sub = s.substring(i, j);
                    if (wordDict.contains(sub)) {
                        containsArray[j] = true;
                    }
                }
            }
        }

        return containsArray[s.length()];
    }
}
