package com.leetcode.trees;

import com.leetcode.common.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.
 *
 * You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked list. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.
 *
 * We want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor.
 * You should return the pointer to the smallest element of the linked list.
 */
public class BinarySearchTreeToDoublyLinkedList_LC426 {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    /**
     * No Arraylist. in place assignment
     * @param root
     * @return
     */
    public Node treeToDoublyList(Node root) {
        if (root == null){
            return root;
        }
        Pair<Node, Node> p = traverseInOrder(root);
        return p.getKey();
    }

    private Pair<Node, Node> traverseInOrder(Node n) {
        if (n.left == null && n.right == null) {
            n.left = n;
            n.right = n;
            return new Pair<Node, Node>(n , n);
        }
        Pair<Node, Node> left = null;
        if (n.left != null) {
            left = traverseInOrder(n.left);
            n.left = left.getValue();
            left.getValue().right = n;
        }
        Pair<Node, Node> right = null;
        if (n.right != null) {
            right = traverseInOrder(n.right);
            n.right = right.getKey();
            right.getKey().left = n;
        }

        Node newLeft = n;
        if (left != null) {
            newLeft = left.getKey();
        }
        Node newRight = n;
        if (right != null) {
            newRight = right.getValue();
        }
        newLeft.left = newRight;
        newRight.right = newLeft;
        return new Pair(newLeft, newRight);
    }

    /**
     * With ArrayList
     * @param root
     * @return
     */
    public Node treeToDoublyListWithArrayList(Node root) {
        if (root == null){
            return root;
        }
        List<Node> inOrderList = new ArrayList<>();
        traverseInOrder(root, inOrderList);
        inOrderList.get(0).left =  inOrderList.get(inOrderList.size() - 1);
        inOrderList.get(inOrderList.size() - 1).right = inOrderList.get(0);
        for (int i=1;i<inOrderList.size();i++) {
            inOrderList.get(i-1).right = inOrderList.get(i);
            inOrderList.get(i).left = inOrderList.get(i-1);
        }
        return inOrderList.get(0);
    }

    private void traverseInOrder(Node n, List<Node> inOrderList) {
        if (n == null) {
            return;
        }
        if (n.left != null) {
            traverseInOrder(n.left, inOrderList);
        }
        inOrderList.add(n);
        if (n.right != null) {
            traverseInOrder(n.right, inOrderList);
        }
    }
}
