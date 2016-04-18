package epi.stacks_queues;

import java.util.Stack;

public class StackWithMax {
	
	private Stack<Integer> input = new Stack<Integer> ();
	private Stack<Integer> max = new Stack<Integer> ();
	
	public void push(int i) {
		input.push(i);
		if(max.isEmpty())
		{
			max.push(i);
		}
		else 
		{
			if (max.peek() < i)
			{
				max.push(i);
			}
			else
			{
				max.push(max.peek());
			}
		}
			
	}

	public int max() {
		return max.peek();
	}

	public Integer pop() {
		max.pop();
		return input.pop();
	}
	
	// Little bit improvement
	public void pushImproved(int i) {
		input.push(i);
		if(max.isEmpty())
		{
			max.push(i);
		}
		else if (i>=max.peek())
		{
			max.push(i);
		}
	}

	public int popImproved() {
		
		int val = input.pop();
		if(val==max.peek())
			max.pop();
		return val;
	}


}
