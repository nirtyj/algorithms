package epi.stacks_queues;

import java.util.Stack;

public class StackReversal {

	public static void reverseStack(Stack<Integer> stack) {
		if (stack.isEmpty())
			return;

		int bottom = getBottom(stack);
		reverseStack(stack);
		stack.push(bottom);
	}

	/**
	 * get the bottom of the stack.
	 * pop.
	 *   check if its the last. yes then return
	 *   else find the lastmost
	 *   push the current pop
	 *   and return the lastmost
	 * @param stack
	 * @return
	 */
	private static int getBottom(Stack<Integer> stack) {
		int last = stack.pop();
		if (stack.isEmpty()) {
			return last;
		} else {
			int lastMost = getBottom(stack);
			stack.push(last);
			return lastMost;
		}
	}
}
