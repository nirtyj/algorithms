package com.leetcode.trees;

import com.leetcode.common.TreeNode;

/**
 * 222. https://leetcode.com/problems/count-complete-tree-nodes/description/
 * Given a complete binary tree, count the number of nodes.
 * <p>
 * Note:
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * <p>
 * Example:
 * Input:
 * 1
 * / \
 * 2   3
 * / \  /
 * 4  5 6
 * <p>
 * Output: 6
 */
public class CountCompleteTreeNodes_222 {

    /**
     * Leetcode verified
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int ll = findLevels(root.left);
        int rl = findLevels(root.right);
        if (ll == rl) {
            return (int) Math.pow(2, ll) + countNodes(root.right);
        } else {
            return (int) Math.pow(2, rl) + countNodes(root.left);
        }
    }

    int findLevels(TreeNode root) {
        if (root == null)
            return 0;
        return findLevels(root.left) + 1;
    }
}
