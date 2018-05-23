package com.leetcode.linkedlist;

import com.leetcode.common.ListNode;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortLinkedList {

	/**
	 * Leetcode verified
	 * @param head
	 * @return
	 */
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		// step 1. cut the list to two halves
		ListNode prev = null, slow = head, fast = head;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		prev.next = null;

		// step 2. sort each half
		ListNode l1 = sortList(head);
		ListNode l2 = sortList(slow);

		// step 3. merge l1 and l2
		return mergeTwoSortedLists(l1, l2);
	}

	ListNode mergeTwoSortedLists(ListNode L1, ListNode L2) {

		if (L1 == null)
			return L2;
		else if (L2 == null)
			return L1;

		ListNode tempHead = new ListNode(0);
		ListNode head = tempHead;

		while (L1 != null && L2 != null) {
			if (L1.val <= L2.val) {
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
