package com.leetcode.linkedlist;

import com.leetcode.common.ListNode;

/**
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
*/
public class ReverseNodesInKGroup {

	/**
	 * Leetcode verified
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null)
			return null;

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode tempHead = dummy;

		ListNode endPrev = dummy;
		ListNode begin = dummy.next;

		while (begin != null) {
			ListNode end = begin;
			ListNode tempEndPrev = begin; // possibly next endprev unless if i not less than k
			int i = 1;
			while (i < k && end.next != null) {
				end = end.next;
				i++;
			}
			if (i != k) {
				endPrev.next = begin;
				break;
			}

			ListNode nextBegin = end.next;
			end.next = null; // mark the end.next as null so its easy to reverse untill null
			endPrev.next = reverseListIterative(begin);
			begin = nextBegin;
			endPrev = tempEndPrev; // switch the begin to the next prevend
		}
		return tempHead.next;
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
