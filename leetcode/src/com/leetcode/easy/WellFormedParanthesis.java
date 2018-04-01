package com.leetcode.easy;

import java.util.Stack;

/**
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/
public class WellFormedParanthesis {
	
	/**
	 * Leetcode verified
	 * @param s
	 * @return
	 */
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (isStarting(c)) {
				stack.push(c);
			} else {
				if (stack.isEmpty())
					return false;

				char old = stack.pop();
				if (isMatching(old, c) == false)
					return false;
			}
		}
		return stack.isEmpty();
	}

	private static boolean isStarting(char in) {
		if (in == '(' || in == '{' || in == '[')
			return true;
		else
			return false;
	}

	private static boolean isMatching(char c1, char c2) {
		if ((c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}')) {
			return true;
		}
		return false;
	}
}
