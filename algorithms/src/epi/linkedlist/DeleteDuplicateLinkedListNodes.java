package epi.linkedlist;

public class DeleteDuplicateLinkedListNodes {

	public static LinkedListNode removeDuplicates(LinkedListNode L) {
		if (L == null || L.next == null)
			return L;

		LinkedListNode prev = L;
		LinkedListNode curr = L.next;

		while (curr != null) {
			if (prev.data != curr.data) {
				prev.next = curr;
				prev = curr;
			}
			curr = curr.next;
		}
		prev.next = curr;

		return L;
	}
}
