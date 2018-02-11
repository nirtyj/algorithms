package leetcode.easy;

import epi.linkedlist.node.ListNode;

/**
Given a linked list, determine if it has a cycle in it.
Follow up:
Can you solve it without using extra space?
*/
public class LinkedListCycle {

	/**
	 * Leetcode verified
	 * @param head
	 * @return
	 */
	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		ListNode slow = head;
		ListNode fast = head;
		boolean hasCycle = false;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				hasCycle = true;
				break;
			}
		}

		return hasCycle;
	}
}
