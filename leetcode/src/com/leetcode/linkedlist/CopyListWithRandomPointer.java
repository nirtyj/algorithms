package com.leetcode.linkedlist;

import com.leetcode.common.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 */
public class CopyListWithRandomPointer {

    /**
     * Leetcode verified
     *
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;

        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode node = head;

        // clone all the nodes first
        while (node != null) {
            RandomListNode newNode = new RandomListNode(node.label);
            map.put(node, newNode);
            node = node.next;
        }

        node = head;
        // make references to other nodes - next & Random
        while (node != null) {
            RandomListNode newNode = map.get(node);
            newNode.next = map.get(node.next);
            newNode.random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }
}