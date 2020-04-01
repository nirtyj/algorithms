package com.leetcode.trees;

import com.leetcode.common.TreeNode;

/**
 * 226. https://leetcode.com/problems/invert-binary-tree/description/
 * Invert a binary tree.
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * to
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 */
public class InvertBinaryTree_226 {

    /**
     * Verified with LeetCode
     *
     * @param root
     * @return
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        return root;
    }
}
