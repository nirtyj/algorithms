package epi.linkedlist;

public class LinkedListClone {

	public static LinkedListNode cloneList(LinkedListNode head) 
	{
		if(head == null)
			return null;
		

		LinkedListNode tempHead = new LinkedListNode(0, null);
		LinkedListNode curr = tempHead;
		while(head != null)
		{
			LinkedListNode node = new LinkedListNode(head.data, null);
			curr.next = node;
			curr = curr.next;
			head = head.next;
		}
		return tempHead.next;
		
	}
}
