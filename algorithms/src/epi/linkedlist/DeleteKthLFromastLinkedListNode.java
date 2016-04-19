package epi.linkedlist;

public class DeleteKthLFromastLinkedListNode {

	public static LinkedListNode removeKthElemnt(LinkedListNode head, int k) {
		if (head == null || head.next == null)
			return null;

		LinkedListNode slow = head;
		LinkedListNode fast = head;

		while (k > 0) {
			fast = fast.next;
			k--;
		}

		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}

		DeleteLinkedListNode.deletionFromList(slow);
		return head;
	}

}
