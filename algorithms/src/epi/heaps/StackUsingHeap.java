package epi.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class StackUsingHeap {

	static class StackNode {
		Integer timeStamp;
		String value;
		public StackNode(int i, String val) {
			this.timeStamp = i;
			this.value = val;
		}
	}

	PriorityQueue<StackNode> insertMinHeap = new PriorityQueue<StackNode>(new Comparator<StackNode>() {

		@Override
		public int compare(StackNode o1, StackNode o2) {
			return Integer.compare(o1.timeStamp, o2.timeStamp);
		}
	});

	int timeStamp = 0;

	public void push(String val)
	{
		insertMinHeap.add(new StackNode(timeStamp++, val));
	}

	public String pop() 
	{
		return insertMinHeap.poll().value;
	}
	
	public String peek()
	{
		return insertMinHeap.peek().value;
	}
}
