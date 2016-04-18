package epi.stacks_queues;

import java.util.Stack;

public class StackWithMaxImproved {
	
	class IntegerWithMax
	{
		IntegerWithMax(Integer val, Integer rep)
		{
			this.val = val;
			this.reptetitions = rep;
		}
		Integer val;
		Integer reptetitions;
	}
	
	Stack<Integer> realStack = new Stack<Integer>();
	Stack<IntegerWithMax> maxStack = new Stack<IntegerWithMax>();
	
	public void push(int i) {
		if(maxStack.isEmpty())
			maxStack.push(new IntegerWithMax(i, 1));
		else if(i>maxStack.peek().val)
			maxStack.push(new IntegerWithMax(i, 1));
		else if (i==maxStack.peek().val)
			maxStack.peek().reptetitions++;
		realStack.push(i);
	}

	public int max() {
		return maxStack.peek().val;
	}

	public int pop() {
		Integer val = realStack.pop();
		if(maxStack.peek().val ==val)
		{
			if(maxStack.peek().reptetitions==1)
				maxStack.pop();
			else
				maxStack.peek().reptetitions--;
		}				
		return val;
	}	
}
