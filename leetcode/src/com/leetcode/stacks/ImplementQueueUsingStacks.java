package com.leetcode.stacks;

import java.util.Stack;

/**
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Example:

MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);  
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false
*/
public class ImplementQueueUsingStacks {

	Stack<Integer> q1 = null;
	Stack<Integer> q2 = null;

	/** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
        q1 = new Stack<Integer>();
        q2 = new Stack<Integer>();
    }

	/** Push element x to the back of queue. */
	public void push(int x) {
		q1.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		shuffle();
		return q2.pop();
	}

	private void shuffle() {
		if (q2.size() == 0) {
			while (q1.size() != 0) {
				q2.push(q1.pop());
			}
		}
	}

	/** Get the front element. */
	public int peek() {
		shuffle();
		return q2.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return (q1.size() == 0 && q2.size() == 0);
	}
}
