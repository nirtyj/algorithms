package com.leetcode.calculator;

import java.util.Iterator;
import java.util.Stack;

/**
 * mplement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 *
 * Example 1:
 *
 * Input: "3+2*2"
 * Output: 7
 * Example 2:
 *
 * Input: " 3/2 "
 * Output: 1
 * Example 3:
 *
 * Input: " 3+5 / 2 "
 * Output: 5
 */
public class BasicCalculatorII_LC227 {

    /**
     * Leetcode verified
     * @param s
     * @return
     */
    public int calculate(String s) {
        char[] str = s.toCharArray();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            // if its a digit,
            if (Character.isDigit(str[i])) {
                // look ahead while trying to parse the num.
                int num = str[i] - '0';
                while (i + 1 < str.length && Character.isDigit(str[i + 1])) {
                    num = num * 10 + str[i + 1] - '0';
                    i++;
                }
                // first element, push
                if (stack.isEmpty()){
                    stack.push(String.valueOf(num));
                } else {
                    // if its * or / before, pop, calculate and then push.
                    String prevSign = stack.peek();
                    if (prevSign.equals("*") || prevSign.equals("/")){
                        prevSign = stack.pop();
                        int prevNum = Integer.parseInt(stack.pop());
                        if (prevSign.equals("*")) {
                            num  = prevNum * num;
                        } else if (prevSign.equals("/")) {
                            num  = prevNum / num;
                        }
                    }
                    stack.push(String.valueOf(num));
                }
            } else if (str[i] == '+' || str[i] == '-' || str[i] == '/' || str[i] == '*') {
                stack.push(String.valueOf(str[i]));
            }
        }

        Iterator<String> value = stack.iterator();
        int num = Integer.parseInt(value.next());
        while (value.hasNext()) {
            String sign = value.next();
            int nextNum = Integer.parseInt(value.next());
            if (sign.equals("+")) {
                num = num + nextNum;
            } else if (sign.equals("-")) {
                num  = num - nextNum;
            }
        }
        return num;
    }
}
