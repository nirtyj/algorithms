package com.leetcode.linkedlist;

import com.leetcode.common.ListNode;

/**
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * <p>
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
 */
public class DeleteLinkedListNode {

    /**
     * Leetcode verified
     *
     * @param node
     */
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
