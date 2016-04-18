package epi.stacks_queues;

import java.util.Stack;

public class QueuesWithStacks {

	Stack<Integer> enqueue = new Stack<Integer>();
	Stack<Integer> dequeue = new Stack<Integer>();

	public boolean enque(Integer e) {
		return enqueue.add(e);
	}

	public Integer dequeue() {
		if (dequeue.isEmpty()) {
			while (enqueue.isEmpty()) {
				dequeue.add(enqueue.pop());
			}
		}

		return dequeue.pop();

	}

}
