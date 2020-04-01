package com.leetcode.linkedlist;

import com.leetcode.common.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * Example:
 * <p>
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Note:
 * <p>
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
public class SwapNodesInPairs {

    /**
     * Leetcode verified
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return head;
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;

        ListNode prev = tempHead;
        ListNode first = head;
        ListNode second = head.next;
        while (first != null && second != null) {
            ListNode n = second.next;
            prev.next = second;
            second.next = first;
            first.next = n;

            prev = first;
            first = n;
            if (first == null) {
                second = null;
            } else {
                second = first.next;
            }
        }

        return tempHead.next;
    }
}
