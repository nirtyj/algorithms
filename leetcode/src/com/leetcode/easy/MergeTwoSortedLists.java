package com.leetcode.easy;

import com.leetcode.common.ListNode;

/**
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
*/
public class MergeTwoSortedLists {

	/**
	 * Leetcode verified
	 * @param L1
	 * @param L2
	 * @return
	 */
	public static ListNode mergeTwoLists(ListNode L1, ListNode L2) {

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
