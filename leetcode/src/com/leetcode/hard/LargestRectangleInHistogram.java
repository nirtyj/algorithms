package com.leetcode.hard;

import java.util.Stack;
/**
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
find the area of largest rectangle in the histogram.

For example,
Given heights = [2,1,5,6,2,3],
return 10.
*/
public class LargestRectangleInHistogram {

	/**
	 * Leetcode verified
	 * @param height
	 * @return
	 */
	public static int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		int i = 0;

		while (i < height.length) {
			//push index to stack when the current height is larger than the previous one
			if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				//calculate max value when the current height is less than the previous one
				int p = stack.pop();
				int h = height[p];
				int w = i;
				if (!stack.isEmpty()) {
					int peekIdx = stack.peek();
					w = i - peekIdx - 1;
				}
				max = Math.max(h * w, max);
			}

		}

		while (!stack.isEmpty()) {
			int p = stack.pop();
			int h = height[p];
			int w = i;
			if (!stack.isEmpty()) {
				int peekIdx = stack.peek();
				w = i - peekIdx - 1;
			}
			max = Math.max(h * w, max);
		}

		return max;
	}
}
