package com.leetcode.trees;

import com.leetcode.common.TreeNode;

/**
 * 110. https://leetcode.com/problems/balanced-binary-tree/description/
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as:
 * <p>
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example 1:
 * <p>
 * Given the following tree [3,9,20,null,null,15,7]:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Return true.
 * <p>
 * Example 2:
 * <p>
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * Return false.
 */
public class BalancedBinaryTree_110 {
    public boolean isBalanced(TreeNode root) {
        return recurseHelper(root).isBalanced;
    }

    private BalancedNode recurseHelper(TreeNode root) {
        if (root == null) {
            BalancedNode node = new BalancedNode(true, 0);
            return node;
        }

        BalancedNode isLeftBalanced = recurseHelper(root.left);
        if (isLeftBalanced.isBalanced == false) {
            return isLeftBalanced;
        }

        BalancedNode isRightBalanced = recurseHelper(root.right);
        if (isRightBalanced.isBalanced == false)
            return isRightBalanced;

        boolean isNodeBalanced = Math.abs(isLeftBalanced.height - isRightBalanced.height) <= 1;
        BalancedNode node = new BalancedNode(isNodeBalanced,
                Math.max(isLeftBalanced.height, isRightBalanced.height) + 1);
        return node;

    }

    /**
     * Leetcode verified
     */
    private static class BalancedNode {
        boolean isBalanced;
        Integer height;

        BalancedNode(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}
