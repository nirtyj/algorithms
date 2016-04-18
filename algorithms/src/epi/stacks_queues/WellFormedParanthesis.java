package epi.stacks_queues;

import java.util.Stack;

public class WellFormedParanthesis {

	public static boolean isWellFormed(String paranthesis)
	{
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0;i<paranthesis.length();i++)
		{
			char c = paranthesis.charAt(i);
			if(isStarting(c))
			{
				stack.push(c);
			}
			else
			{
				char old = stack.pop();
				if(isMatching(old, c) == false)
					return false;
			}
		}
		
		return stack.isEmpty();
	}
	
	private static boolean isStarting(char in)
	{
		if (in == '(' || in == '{' || in == '[')
			return true;
		else
			return false;
	}	
	
	private static boolean isMatching(char c1, char c2)
	{
		if((c1 == '(' && c2 == ')') || (c1=='[' && c2 ==']') || (c1=='{' && c2 =='}' ))
		{
			return true;
		}
		return false;
	}
}
