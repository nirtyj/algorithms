package com.leetcode.easy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
*/
public class MinStack {

	PriorityQueue<Integer> q;
	Stack<Integer> stack;

	/** Leetcode verified */
	public MinStack() {
		q = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		});
		stack = new Stack<Integer>();
	}

	public void push(int x) {
		q.add(x);
		stack.push(x);
	}

	public void pop() {
		Integer val = stack.pop();
		q.remove(val);
	}

	/**
	 * O(1) - constant time
	 * 
	 * @return
	 */
	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return q.peek();
	}
}
