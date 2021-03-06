package com.leetcode.trees;

import com.leetcode.common.TreeNode;

/**
 * 129. https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * <p>
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * <p>
 * Find the total sum of all root-to-leaf numbers.
 * <p>
 * For example,
 * <p>
 * 1
 * / \
 * 2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 */
public class SumRootToLeaf_129 {

    /**
     * Leetcode verified
     *
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        return findSumFromRootHelper(root, 0);
    }

    private int findSumFromRootHelper(TreeNode node, int partialSum) {
        if (node == null)
            return 0;

        int sum = node.val + partialSum;
        if (node.left == null && node.right == null)
            return sum;
        return findSumFromRootHelper(node.left, sum * 10) + findSumFromRootHelper(node.right, sum * 10);
    }
}
