package com.leetcode.easy;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * <p>
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class MinStack {

    int minValue = Integer.MAX_VALUE;
    Stack<Integer> stack;
    /**
     * With queue. more space
     */
    PriorityQueue<Integer> q;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<Integer>();
    }

    public void push(int x) {
        if (x <= minValue) {
            stack.push(minValue);
            minValue = x;
        }
        stack.push(x);
    }

    public void pop() {
        Integer val = stack.pop();
        if (val == minValue)
            minValue = stack.pop();
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
        return minValue;
    }

    public void push1(int x) {
        q.add(x);
        stack.push(x);
    }

    public void pop1() {
        Integer val = stack.pop();
        q.remove(val);
    }

    /**
     * O(1) - constant time
     *
     * @return
     */
    public int top1() {
        return stack.peek();
    }

    public int getMin1() {
        return q.peek();
    }
}
