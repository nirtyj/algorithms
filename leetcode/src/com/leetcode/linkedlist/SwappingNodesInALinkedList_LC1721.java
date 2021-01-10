package com.leetcode.linkedlist;

import com.leetcode.common.ListNode;

/**
 * You are given the head of a linked list, and an integer k.
 *
 * Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [1,4,3,2,5]
 * Example 2:
 *
 * Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * Output: [7,9,6,6,8,7,3,0,9,5]
 * Example 3:
 *
 * Input: head = [1], k = 1
 * Output: [1]
 * Example 4:
 *
 * Input: head = [1,2], k = 1
 * Output: [2,1]
 * Example 5:
 *
 * Input: head = [1,2,3], k = 2
 * Output: [1,2,3]
 */
public class SwappingNodesInALinkedList_LC1721 {
    /**
     * Find the size then do it.
     * @param head
     * @param k
     * @return
     */
    public ListNode swapNodes(ListNode head, int k) {
        int size = size(head);
        int endIndex = size - k + 1;
        if (size == 1 || endIndex < 1 || k == endIndex) {
            return head;
        }
        int i = 1;
        ListNode startK = null;
        ListNode endK = null;
        ListNode temp = head;
        while (i <= Math.max(k, endIndex)) {
            if (i == k) {
                startK = temp;
            } else if (i == endIndex) {
                endK = temp;
            }
            temp = temp.next;
            i++;
        }
        int tempVal = endK.val;
        endK.val = startK.val;
        startK.val = tempVal;
        return head;
    }

    int size(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}
