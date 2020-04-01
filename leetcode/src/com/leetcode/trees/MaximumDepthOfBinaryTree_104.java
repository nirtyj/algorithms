package com.leetcode.trees;

import com.leetcode.common.TreeNode;

/**
 * 104. https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its depth = 3.
 */
public class MaximumDepthOfBinaryTree_104 {

    /**
     * Leetcode verified
     *
     * @param tree
     * @return
     */
    public int maxDepth(TreeNode tree) {
        if (tree == null)
            return 0;

        return Math.max(maxDepth(tree.left), maxDepth(tree.right)) + 1;
    }
}
