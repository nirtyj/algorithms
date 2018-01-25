package epi.stacks_queues;

import java.util.Stack;

/**
 * Leetcode verified
 * @author njaganathan
 */
public class WellFormedParanthesis {

	public boolean isValid(String s) {
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

	private boolean isStarting(char in) {
		if (in == '(' || in == '{' || in == '[')
			return true;
		else
			return false;
	}

	private boolean isMatching(char c1, char c2) {
		if ((c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}')) {
			return true;
		}
		return false;
	}
}
