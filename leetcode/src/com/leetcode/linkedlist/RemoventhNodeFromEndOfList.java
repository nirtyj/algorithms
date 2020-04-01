package com.leetcode.linkedlist;

import com.leetcode.common.ListNode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * <p>
 * Given n will always be valid.
 */
public class RemoventhNodeFromEndOfList {

    /**
     * Leetcode verified
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode begin = new ListNode(0);
        ListNode start = begin;
        begin.next = head;

        ListNode end = head;
        int i = 1;
        while (i < n) {
            end = end.next;
            i++;
        }

        while (end.next != null) {
            begin = begin.next;
            end = end.next;
        }

        begin.next = begin.next.next;
        return start.next;
    }
}
