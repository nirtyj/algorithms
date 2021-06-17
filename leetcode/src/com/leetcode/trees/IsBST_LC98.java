package com.leetcode.trees;

import com.leetcode.common.TreeNode;

/**
 * 98. https://leetcode.com/problems/validate-binary-search-tree/description/
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 * 2
 * / \
 * 1   3
 * Binary tree [2,1,3], return true.
 * Example 2:
 * 1
 * / \
 * 2   3
 * Binary tree [1,2,3], return false.
 */
public class IsBST_LC98 {
    /**
     * Leetcode verified
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isBstHelper(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    private boolean isBstHelper(TreeNode root, double min, double max) {
        if (root == null)
            return true;
        if (root.val > min && root.val < max)
            return isBstHelper(root.left, min, root.val) && isBstHelper(root.right, root.val, max);
        else
            return false;
    }
}
