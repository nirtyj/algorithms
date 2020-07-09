package com.leetcode.sliding_window;

/**
 * Given a string s consisting only of characters a, b and c.
 *
 * Return the number of substrings containing at least one occurrence of all these characters a, b and c.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabc"
 * Output: 10
 * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
 * Example 2:
 *
 * Input: s = "aaacb"
 * Output: 3
 * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
 * Example 3:
 *
 * Input: s = "abc"
 * Output: 1
 *
 *
 * Constraints:
 *
 * 3 <= s.length <= 5 x 10^4
 * s only consists of a, b or c characters.
 */
public class NumberOfSubstringsContainingAllThreeChar_LC1358 {

    /**
     * adding i to result, as all the chars left of i are substrings. could be replaced with another counter
     * @param s
     * @return
     */
    public int numberOfSubstringsSlidingWindow(String s) {
        int count[] = {0, 0, 0}, res = 0 , i = 0;
        for (int j = 0; j < s.length(); j++) {
            count[s.charAt(j) - 'a']++;
            while (count[0] > 0 && count[1] > 0 && count[2] > 0){ // if all three chars have been seen
                count[s.charAt(i) - 'a']--;
                i++;
            }
            res += i;
        }
        return res;
    }

    /**
     * Use index position and calculate. all chars left of min of last is substring
     * @param s
     * @return
     */
    public int numberOfSubstringsIndexPosition(String s) {
        int last[] = {-1, -1, -1}, res = 0;
        for (int i = 0; i < s.length(); ++i) {
            last[s.charAt(i) - 'a'] = i;
            if (last[0] > -1 && last[1] > -1 && last[2] > -1) { // if all three chars have been seen
                res += 1 + Math.min(last[0], Math.min(last[1], last[2]));
            }
        }
        return res;
    }
}
