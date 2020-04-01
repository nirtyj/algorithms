package com.leetcode.medium;

/**
 * 8. https://leetcode.com/problems/string-to-integer-atoi/
 * Implement atoi which converts a string to an integer.
 * <p>
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 * <p>
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * <p>
 * If no valid conversion could be performed, a zero value is returned.
 * <p>
 * Note:
 * <p>
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * Example 1:
 * <p>
 * Input: "42"
 * Output: 42
 * Example 2:
 * <p>
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 * Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 * <p>
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 * <p>
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 * <p>
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 * Thefore INT_MIN (−231) is returned.
 */
public class AtoI_8 {

    /**
     * Leetcode verified
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        if (str == null)
            return 0;
        str = str.trim();
        if (str.isEmpty())
            return 0;
        int start = 0;
        int sign = 1;
        long sum = 0;
        if (str.charAt(0) == '-') {
            sign = -1;
            start++;
        } else if (str.charAt(0) == '+') {
            start++;
        }
        for (int i = start; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) {
                return (int) (sign * sum);
            }
            sum = sum * 10 + (c - '0');
            if (sign * sum > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (sign * sum < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) (sign * sum);
    }
}
