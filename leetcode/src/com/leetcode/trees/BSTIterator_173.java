package com.leetcode.trees;

import com.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * 173. https://leetcode.com/problems/binary-search-tree-iterator/description/
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * <p>
 * Calling next() will return the next smallest number in the BST.
 * <p>
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
public class BSTIterator_173 {
    /**
     * Leetcode verified
     */
    Stack<TreeNode> stack = null;

    public BSTIterator_173(TreeNode root) {
        stack = new Stack<TreeNode>();
        if (root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = stack.pop();
        if (node == null)
            return Integer.MIN_VALUE;
        TreeNode result = node;

        if (node.right != null) {
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return result.val;
    }
}
