package epi.linkedlist;

public class LinkedListNode {

	public String value;
	public LinkedListNode next;
	

	public LinkedListNode()
	{
		
	}
	
	public LinkedListNode(String value)
	{
		this.value = value;
	}
	
	@Override
	public String toString()
	{
		String nextVal = "null";
		if(next != null)
			nextVal = next.toString();
		return "\""+ this.value +"\""+ "->" + nextVal;		
	}
}
