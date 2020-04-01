package com.leetcode.trees;

import com.leetcode.common.TreeNode;

/**
 * 404. https://leetcode.com/problems/sum-of-left-leaves/description/
 * <p>
 * Find the sum of all left leaves in a given binary tree.
 * <p>
 * Example:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class SumOfLeftLeaves_404 {

    /**
     * Leetcode verified
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        int result = 0;
        if (root == null)
            return result;

        if (root.left != null) {
            if (root.left.left == null && root.left.right == null)
                result = result + root.left.val;
            else
                result = result + sumOfLeftLeaves(root.left);
        }

        if (root.right != null) {
            result = result + sumOfLeftLeaves(root.right);
        }
        return result;
    }
}
