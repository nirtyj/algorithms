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
    public int numberOfSubstrings(String s) {
        int count[] = {0, 0, 0}, result = 0;
        int begin = 0; // back pointer
        int ans = 0;
        for (int end = 0; end < s.length(); end++) {
            count[s.charAt(end) - 'a']++;
            while(begin <= end && count[0] > 0 && count[1] > 0 && count[2] > 0){
                ans++; // keep the previous sum as its substrings
                count[s.charAt(begin) - 'a']--; // modify the condition
                begin++; // increase the back pointer.
            }
            result = result + ans;
        }
        return result;
    }
}
