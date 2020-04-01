package com.leetcode.trees;

import com.leetcode.common.TreeNode;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <p>
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class TreeFromPreAndInOrder {

    private static TreeNode helper(int[] inorder, int i, int j, int[] preorder, int curr) {
        if (j < 0 || i > inorder.length - 1 || curr >= preorder.length)
            return null;
        if (i == j)
            return new TreeNode(inorder[i]);

        int val = preorder[curr];
        int index = findinInOrder(inorder, i, j, val);
        if (index == -1)
            return null;

        TreeNode node = new TreeNode(val);
        node.left = helper(inorder, i, index - 1, preorder, curr + 1);
        node.right = helper(inorder, index + 1, j, preorder, curr + 1 + (index - i));

        return node;
    }

    private static int findinInOrder(int[] inor, int i, int j, int val) {
        for (; i <= j; i++) {
            if (inor[i] == val) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Leetcode accepted and verified
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (inorder == null || preorder == null || inorder.length != preorder.length)
            return null;
        return helper(inorder, 0, inorder.length - 1, preorder, 0);
    }
}
