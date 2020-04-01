package com.leetcode.trees;

import com.leetcode.common.TreeNode;

/**
 * 687. https://leetcode.com/problems/longest-univalue-path/description/
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.
 * <p>
 * Note: The length of path between two nodes is represented by the number of edges between them.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * <p>
 * 5
 * / \
 * 4   5
 * / \   \
 * 1   1   5
 * Output:
 * <p>
 * 2
 * Example 2:
 * <p>
 * Input:
 * <p>
 * 1
 * / \
 * 4   5
 * / \   \
 * 4   4   5
 * Output:
 * <p>
 * 2
 * Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
 */
public class LongestUnivaluePath_687 {

    int len = 0; // global variable

    /**
     * Leetcode verified
     *
     * @param root
     * @return
     */
    public int longestUnivaluePath(TreeNode root) {
        len = 0;
        if (root == null)
            return len;

        getLen(root, root.val);
        return len;
    }

    private int getLen(TreeNode node, int rootVal) {
        if (node == null)
            return 0;
        int left = getLen(node.left, node.val);
        int right = getLen(node.right, node.val);
        len = Math.max(len, left + right);
        if (rootVal == node.val)
            return Math.max(left, right) + 1;
        return 0;
    }
}
