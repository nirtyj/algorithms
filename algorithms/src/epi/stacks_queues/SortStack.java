package epi.stacks_queues;

import java.util.Stack;

public class SortStack {

	/**
	 * https://www.youtube.com/watch?v=Jhaf7G_sO3k
	 * pop one from s and assign it to curr
	 * 
	 * try to put curr on top of r.
	 * if r is empty , just push it
	 * else
	 *  pop from r and push into s, until the value is less than curr
	 *  
	 * continue until there is no val in s
	 * @param s
	 * @return
	 */
	public static Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<>();
		while (!s.isEmpty()) {
			int curr = s.pop();
			while (!r.empty() && r.peek() > curr) {
				s.push(r.pop());
			}
			r.push(curr);
		}
		return r;
	}

	/**
	 * using recursion 
	 * 
	 * keep popping until no element.
	 * 
	 * now push on the sorted order.
	 * 
	 * @param s
	 * @return
	 */
	public static Stack<Integer> sortRecursion(Stack<Integer> s) {

		if (!s.isEmpty()) {
			int curr = s.pop();
			sortRecursion(s);
			insertSorted(s, curr);
		}
		return s;
	}

	private static void insertSorted(Stack<Integer> s, int curr) {
		if (s.isEmpty()) {
			s.push(curr);
		}
		else
		{
			int topmost = s.peek();
			if (topmost < curr) {
				s.push(curr);
			} else {
				topmost = s.pop();
				insertSorted(s, curr);
				s.push(topmost);
			}
		}
	}
}
