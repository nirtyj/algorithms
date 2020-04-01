package com.leetcode.trees;

import com.leetcode.common.TreeNode;

/**
 * 114. https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 * Given a binary tree, flatten it to a linked list in-place.
 * For example, given the following tree:
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * The flattened tree should look like:
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 */
public class FlattenBinaryTreeToLinkedList_114 {

    /**
     * Leet code accepted & verified
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        helper(root);
    }

    TreeNode helper(TreeNode root) {
        if (root.left == null && root.right == null)
            return root;

        TreeNode flattendLeft = null, flattendRight = null;

        if (root.left != null)
            flattendLeft = helper(root.left);
        if (root.right != null)
            flattendRight = helper(root.right);

        if (flattendLeft == null)
            root.right = flattendRight;
        else {
            root.right = flattendLeft;
            TreeNode curr = flattendLeft;
            while (curr.right != null) {
                curr = curr.right;
            }
            curr.right = flattendRight;
        }

        root.left = null;
        return root;
    }
}
