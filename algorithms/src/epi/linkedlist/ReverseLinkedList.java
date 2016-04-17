package epi.linkedlist;

public class ReverseLinkedList {

	public static LinkedListNode reverseList(LinkedListNode node)
	{
		if(node.next == null)
			return node;
		
		LinkedListNode prev = reverseList(node.next);
		
		LinkedListNode last = prev;
		while(last.next != null)
			last = last.next;
		
		node.next = null;
		last.next = node;
		return prev;
	}
}
