package com.leetcode.calculator;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 *
 * Example 1:
 *
 * Input: "1 + 1"
 * Output: 2
 * Example 2:
 *
 * Input: " 2-1 + 2 "
 * Output: 3
 * Example 3:
 *
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * Note:
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */
public class BasicCalculator_LC224 {

    /**
     * leetcode verified
     * @param s
     * @return
     */
    public int calculate(String s) {
        char[] str = s.toCharArray();
        int sign = 1;
        int result = 0;
        Stack<Integer> stack = new Stack<>(); // stack only used when there is ( or ).
        // when you hit a (, push the previous result and sign
        // when you hit a ), pop the previous  sign * current result + previous result.
        // when you hit a num, use result = result + sign * num, to do all computations for 2 + 2 + 1...
        // look ahead while trying to parse the num.
        for (int i = 0; i < str.length; i++) {
            // if its a digit,
            if (Character.isDigit(str[i])) {
                // look ahead while trying to parse the num.
                int num = str[i] - '0';
                while (i + 1 < str.length && Character.isDigit(str[i + 1])) {
                    num = num * 10 + str[i + 1] - '0';
                    i++;
                }
                result = result + num * sign;
            } else if (str[i] == '+') {
                sign = +1;
            } else if (str[i] == '-') {
                sign = -1;
            } else if (str[i] == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (str[i] == ')') {
                //  pop the previous  sign * current result + previous result.
                result = result * stack.pop() + stack.pop();
            }
        }
        return result;
    }
}
