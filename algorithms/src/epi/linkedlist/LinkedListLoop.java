package epi.linkedlist;

public class LinkedListLoop {

	public static LinkedListNode findCycle(LinkedListNode head) {
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		boolean hasCycle = false;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				hasCycle = true;
				break;
			}
		}

		if (!hasCycle)
			return null;

		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;

	}
}
