package epi.linkedlist;

public class ReverseSubLinkedList {

	public static LinkedListNode reverseSublist(LinkedListNode L, int start, int finish) {

		if (start == finish)
			return L;

		LinkedListNode tempHead = new LinkedListNode(0, L);
		LinkedListNode head = L;
		LinkedListNode listEnd = null;
		LinkedListNode startNode = null;
		LinkedListNode finishNode = null;
		LinkedListNode finishStart = null;

		int count = 0;
		LinkedListNode prev = tempHead;
		while (head != null) {
			if (count == start) {
				listEnd = prev;
				startNode = head;
			} else if (count == finish) {
				finishNode = head;
				finishStart = head.next;
				break;
			}
			prev = head;
			head = head.next;
			count++;
		}

		// break the list
		finishNode.next = null;

		//reverse the sublist
		LinkedListNode reversed = ReverseLinkedList.reverseListIterative(startNode);

		// attach the old end to new reversed
		listEnd.next = reversed;

		// attach the remaining portion of original list to start of the orginal list
		startNode.next = finishStart;
		return tempHead.next;
	}
}
