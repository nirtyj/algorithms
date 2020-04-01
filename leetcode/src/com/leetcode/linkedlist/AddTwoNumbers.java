package com.leetcode.linkedlist;

import com.leetcode.common.ListNode;

import java.util.Stack;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * <p>
 * Example:
 * <p>
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbers {

    /**
     * Leetcode verified
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;

        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                stack1.push(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                stack2.push(l2.val);
                l2 = l2.next;
            }
        }
        ListNode result = new ListNode(0);
        int carry = 0;
        ListNode prev = result;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int rl1val = stack1.isEmpty() ? 0 : stack1.pop();
            int rl2val = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = rl1val + rl2val + carry;
            ListNode n = new ListNode(sum % 10);
            carry = sum / 10;
            n.next = prev.next;
            prev.next = n;
        }
        if (carry > 0) {
            ListNode n = new ListNode(carry);
            n.next = prev.next;
            prev.next = n;
        }
        return result.next;
    }

    /**
     * Leetcode verified
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersNoExtraSpace(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        ListNode rl1 = reverseList(l1);
        ListNode rl2 = reverseList(l2);
        ListNode result = new ListNode(0);
        int carry = 0;
        ListNode prev = result;
        while (rl1 != null || rl2 != null) {
            int rl1val = rl1 == null ? 0 : rl1.val;
            int rl2val = rl2 == null ? 0 : rl2.val;
            int sum = rl1val + rl2val + carry;
            ListNode n = new ListNode(sum % 10);
            carry = sum / 10;
            if (rl1 != null)
                rl1 = rl1.next;
            if (rl2 != null)
                rl2 = rl2.next;
            prev.next = n;
            prev = prev.next;
        }
        if (carry > 0) {
            ListNode n = new ListNode(carry);
            prev.next = n;
        }
        result.next = reverseList(result.next);
        return result.next;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode node = head;
        while (node.next != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        node.next = prev;
        return node;
    }
}
