package com.leetcode.sliding_window;

/**
 * You are given two strings s and t of the same length. You want to change s to t. Changing the i-th character of s to i-th character of t costs |s[i] - t[i]| that is, the absolute difference between the ASCII values of the characters.
 *
 * You are also given an integer maxCost.
 *
 * Return the maximum length of a substring of s that can be changed to be the same as the corresponding substring of twith a cost less than or equal to maxCost.
 *
 * If there is no substring from s that can be changed to its corresponding substring from t, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcd", t = "bcdf", maxCost = 3
 * Output: 3
 * Explanation: "abc" of s can change to "bcd". That costs 3, so the maximum length is 3.
 * Example 2:
 *
 * Input: s = "abcd", t = "cdef", maxCost = 3
 * Output: 1
 * Explanation: Each character in s costs 2 to change to charactor in t, so the maximum length is 1.
 * Example 3:
 *
 * Input: s = "abcd", t = "acde", maxCost = 0
 * Output: 1
 * Explanation: You can't make any change, so the maximum length is 1
 */
public class GetEqualSubstringsWithinBudget_LC1208 {

    /**
     * @param s
     * @param t
     * @param maxCost
     * @return
     */
    public int equalSubstring(String s, String t, int maxCost) {
        int begin = 0;
        int result = 0;
        int totalCost = 0;
        for(int end = 0; end < s.length(); end++){
            totalCost =  totalCost + Math.abs(s.charAt(end) - t.charAt(end));
            while(totalCost > maxCost && begin <= end){
                int beginCost = Math.abs(s.charAt(begin) - t.charAt(begin));
                totalCost = totalCost - beginCost;
                begin++;
            }
            result = Math.max(result, end - begin + 1);
        }
        return result;
    }
}
