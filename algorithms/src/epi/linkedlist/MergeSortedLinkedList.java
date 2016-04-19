package epi.linkedlist;

public class MergeSortedLinkedList {

	public static LinkedListNode mergeTwoSortedLists(LinkedListNode L1, LinkedListNode L2) {

		if (L1 == null)
			return L2;
		else if (L2 == null)
			return L1;

		LinkedListNode tempHead = new LinkedListNode();
		LinkedListNode head = tempHead;

		while (L1 != null && L2 != null) {
			if (L1.data <= L2.data) {
				tempHead.next = L1;
				L1 = L1.next;
			} else {
				tempHead.next = L2;
				L2 = L2.next;
			}
			tempHead = tempHead.next;
		}

		if (L1 == null)
			tempHead.next = L2;
		else
			tempHead.next = L1;

		return head.next;
	}
}
