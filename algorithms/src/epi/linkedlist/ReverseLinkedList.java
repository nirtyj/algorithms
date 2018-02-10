package epi.linkedlist;

import epi.linkedlist.node.ListNode;

public class ReverseLinkedList {

	public static LinkedListNode reverseList(LinkedListNode node) {
		if (node.next == null)
			return node;

		LinkedListNode prev = reverseList(node.next);

		LinkedListNode last = prev;
		while (last.next != null)
			last = last.next;

		node.next = null;
		last.next = node;
		return prev;
	}

	public static LinkedListNode reverseListRecursive(LinkedListNode head) {
		if (head == null || head.next == null)
			return head;

		LinkedListNode nextNode = head.next;

		LinkedListNode last = reverseListRecursive(head.next);
		head.next = null;
		nextNode.next = head;
		return last;
	}

	public static LinkedListNode reverseListIterative(LinkedListNode head) {

		LinkedListNode prev = head;
		LinkedListNode curr = head.next;
		prev.next = null;
		while (curr != null) {
			LinkedListNode nxtNode = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nxtNode;
		}
		return prev;
	}
	
	/**
	 * Leetcode verified
	 */
	public static ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        while(next != null)
        {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        return curr;
    }
}
