package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given two 1d vectors, implement an iterator to return their elements alternately.
 * <p>
 * For example, given two 1d vectors:
 * <p>
 * v1 = [1, 2]
 * v2 = [3, 4, 5, 6]
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].
 * <p>
 * Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
 * <p>
 * Clarification for the follow up question - Update (2015-09-18):
 * The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:
 * <p>
 * [1,2,3]
 * [4,5,6,7]
 * [8,9]
 * It should return [1,4,8,2,5,9,3,6,7]
 */
public class ZigzagIterator {

    /**
     * Easy solution - Genious!!
     */
    Queue<Iterator<Integer>> list;
    int nextListIndex = 0;
    List<NodeIndex> lists = new ArrayList<>();

    /**
     * Leetcode verified
     *
     * @param v1
     * @param v2
     */
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        if (v1 != null && !v1.isEmpty()) {
            lists.add(new NodeIndex(v1));
        }
        if (v2 != null && !v2.isEmpty()) {
            lists.add(new NodeIndex(v2));
        }
    }

    public void ZigzagIteratorBest(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<Iterator<Integer>>();
        if (!v1.isEmpty()) list.add(v1.iterator());
        if (!v2.isEmpty()) list.add(v2.iterator());
    }

    public int nextVal() {
        Iterator<Integer> poll = list.remove();
        int result = poll.next();
        if (poll.hasNext()) list.add(poll);
        return result;
    }

    public boolean hasNextVal() {
        return !list.isEmpty();
    }

    public int next() {
        if (hasNext()) {
            NodeIndex givenListNode = lists.get(nextListIndex);
            int valToReturn = givenListNode.list.get(givenListNode.nextIndex);
            if (givenListNode.nextIndex + 1 == givenListNode.list.size()) {
                lists.remove(nextListIndex);
            } else {
                givenListNode.nextIndex = givenListNode.nextIndex + 1;
            }
            if (nextListIndex + 1 >= lists.size()) {
                nextListIndex = 0;
            } else {
                nextListIndex = nextListIndex + 1;
            }
            return valToReturn;
        }
        return Integer.MIN_VALUE;
    }

    public boolean hasNext() {
        return !lists.isEmpty();
    }

    public static class NodeIndex {
        int nextIndex = 0;
        List<Integer> list;

        NodeIndex(List<Integer> list) {
            this.list = list;
        }
    }

}