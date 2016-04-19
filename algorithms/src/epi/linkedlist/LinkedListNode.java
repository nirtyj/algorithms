package epi.linkedlist;

public class LinkedListNode {

	public String value;
	public Integer data;
	public LinkedListNode next;
	

	public LinkedListNode()
	{
		
	}
	
	public LinkedListNode(String value)
	{
		this.value = value;
	}
	
	public LinkedListNode(Integer data, LinkedListNode next)
	{
		this.data = data;
		this.next = next;
	}
	
	public int size()
	{
		int count = 1;
		LinkedListNode nextNode = next;
		while(nextNode!=null)
		{
			count++;
			nextNode = nextNode.next;
		}
		return count;
	}
	
	@Override
	public String toString()
	{
		String nextVal = "null";
		if(next != null)
			nextVal = next.toString();
		return "\""+ (this.value == null? this.data : this.value) +"\""+ "->" + nextVal;		
	}
}
