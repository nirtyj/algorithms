package com.leetcode.easy;

import com.leetcode.common.ListNode;

/**
Reverse a singly linked list.
*/
public class ReverseLinkedList {

	/**
	 * Leetcode verified
	 */
	public static ListNode reverseList1(ListNode head) {
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
	
	public static ListNode reverseList(ListNode node) {
		if (node.next == null)
			return node;

		ListNode prev = reverseList(node.next);

		ListNode last = prev;
		while (last.next != null)
			last = last.next;

		node.next = null;
		last.next = node;
		return prev;
	}

	public static ListNode reverseListRecursive(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode nextNode = head.next;

		ListNode last = reverseListRecursive(head.next);
		head.next = null;
		nextNode.next = head;
		return last;
	}

	public static ListNode reverseListIterative(ListNode head) {

		ListNode prev = head;
		ListNode curr = head.next;
		prev.next = null;
		while (curr != null) {
			ListNode nxtNode = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nxtNode;
		}
		return prev;
	}
}
