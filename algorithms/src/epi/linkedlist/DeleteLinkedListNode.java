package epi.linkedlist;

public class DeleteLinkedListNode {

	public static void deletionFromList(LinkedListNode node)
	{
		node.data = node.next.data;
		node.next = node.next.next;
	}	
}
