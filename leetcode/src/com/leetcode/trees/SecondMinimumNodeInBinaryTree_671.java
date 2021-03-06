package com.leetcode.trees;

import com.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 671. https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/
 * Given a non-empty special binary tree consisting of nodes with the non-negative value,
 * where each node in this tree has exactly two or zero sub-node.
 * If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.
 * <p>
 * Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
 * <p>
 * If no such second minimum value exists, output -1 instead.
 * <p>
 * Example 1:
 * Input:
 * 2
 * / \
 * 2   5
 * / \
 * 5   7
 * <p>
 * Output: 5
 * Explanation: The smallest value is 2, the second smallest value is 5.
 * Example 2:
 * Input:
 * 2
 * / \
 * 2   2
 * <p>
 * Output: -1
 * Explanation: The smallest value is 2, but there isn't any second smallest value.
 */
public class SecondMinimumNodeInBinaryTree_671 {

    /**
     * Leetcode verified
     *
     * @param root
     * @return
     */
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return -1;
        int min = root.val;
        int result = Integer.MAX_VALUE;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            if (n.val > min && n.val < result) {
                result = n.val;
                if (result == min + 1)
                    return result;
            }
            if (n.left != null)
                q.offer(n.left);
            if (n.right != null)
                q.offer(n.right);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
