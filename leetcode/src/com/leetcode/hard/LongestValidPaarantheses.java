package com.leetcode.hard;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * Example 1:
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * <p>
 * Example 2:
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */
public class LongestValidPaarantheses {

    /**
     * Leetcode verified - two pass O(n)
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                left++;
            else {
                right++;
                if (left == right) {
                    max = Math.max(max, left + right);
                } else if (right > left) {
                    left = 0;
                    right = 0;
                }
            }
        }
        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')')
                right++;
            else {
                left++;
                if (left == right) {
                    max = Math.max(max, left + right);
                } else if (left > right) {
                    left = 0;
                    right = 0;
                }
            }
        }
        return max;
    }

    /**
     * Leetcode verified
     *
     * @param s
     * @return
     */
    public int longestValidParenthesesStack(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int left = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                if (stack.isEmpty()) {
                    left = i;
                    continue;
                }
                stack.pop();
                if (stack.isEmpty()) {
                    max = Math.max(max, i - left);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
