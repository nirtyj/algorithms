package com.leetcode.trees;

import com.leetcode.common.TreeNode;

/**
 * 100. https://leetcode.com/problems/same-tree/
 * Given two binary trees, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 */
public class IsSameTrees_100 {
    /**
     * Leetcode verified
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if ((p != null && q == null) || (p == null && q != null) || (p.val != q.val))
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
