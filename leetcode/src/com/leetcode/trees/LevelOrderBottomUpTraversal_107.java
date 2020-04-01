package com.leetcode.trees;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class LevelOrderBottomUpTraversal_107 {

    /**
     * Leetcode verified
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> tempResult = new ArrayList<Integer>();
            while (size > 0) {
                TreeNode node = q.poll();
                tempResult.add(node.val);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                size--;
            }
            result.addFirst(tempResult);
        }
        return result;
    }
}
