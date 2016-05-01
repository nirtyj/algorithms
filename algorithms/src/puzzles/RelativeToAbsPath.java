package puzzles;

import java.util.Iterator;
import java.util.LinkedList;

public class RelativeToAbsPath {

	public static String resolvePath(String input)
	{
		LinkedList<String> stack = new LinkedList<String>();
		
		String[] tokens = input.split("/");
		for(String token : tokens)
		{
			if(!token.isEmpty())
				stack.addLast(token);
		}

		LinkedList<String> modifiedstack = new LinkedList<String>();
		
		Iterator<String> it = stack.descendingIterator();
		while(it.hasNext())
		{
			String val = it.next();			
			if(val.equals(".."))
			{	
				int count = 0;				
				while (it.hasNext() && it.next().equals(".."))
					count++;
				while(count>0)
				{
					it.next();
					count--;
				}
			}
			else
			{
				modifiedstack.push(val);
			}
		}
		
		StringBuilder builder = new StringBuilder();
		for(String keys : modifiedstack)
		{
			builder.append("/").append(keys);
		}
		return builder.toString();
	}
}
