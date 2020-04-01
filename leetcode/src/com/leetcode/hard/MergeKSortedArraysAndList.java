package com.leetcode.hard;

import com.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class MergeKSortedArraysAndList {

    Comparator<ListNode> comp = new Comparator<ListNode>() {
        @Override
        public int compare(ListNode node1, ListNode node2) {
            return Integer.compare(node1.val, node2.val);
        }
    };

    public static List<Integer> mergeKArrays(List<List<Integer>> arrOfArrays) {
        List<Integer> result = new ArrayList<Integer>();
        PriorityQueue<ArrayNode> minHeap = new PriorityQueue<ArrayNode>(arrOfArrays.size(),
                new Comparator<ArrayNode>() {

                    @Override
                    public int compare(ArrayNode o1, ArrayNode o2) {
                        return Integer.compare(o1.value, o2.value);
                    }
                });

        for (int i = 0; i < arrOfArrays.size(); i++) {
            minHeap.add(new ArrayNode(arrOfArrays.get(i).get(0), i, 1));
        }

        while (minHeap.peek() != null) {
            ArrayNode node = minHeap.poll();
            result.add(node.value);
            List<Integer> array = arrOfArrays.get(node.arrayId);
            if (node.nextIndex < array.size()) {
                minHeap.add(new ArrayNode(array.get(node.nextIndex), node.arrayId, node.nextIndex + 1));
            }
        }
        return result;
    }

    /**
     * Leetcode verified
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        else if (lists.length == 1)
            return lists[0];
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, comp);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                heap.add(lists[i]);
        }
        ListNode resultHead = new ListNode(0);
        ListNode result = resultHead;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            result.next = node;
            if (node.next != null)
                heap.add(node.next);
            result = result.next;
        }
        result.next = null;
        return resultHead.next;
    }

    public static class ArrayNode {
        int value;
        int arrayId;
        int nextIndex;

        public ArrayNode(int value, int arrayId, int nextIndex) {
            this.value = value;
            this.arrayId = arrayId;
            this.nextIndex = nextIndex;
        }
    }

}
