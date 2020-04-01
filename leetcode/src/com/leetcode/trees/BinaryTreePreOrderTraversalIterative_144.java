package com.leetcode.trees;

import com.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 144. https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * Example:
 * <p>
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * Output: [1,2,3]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreOrderTraversalIterative_144 {

    /**
     * Leetcode verified
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if (root == null)
            return res;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            res.add(curr.val);
            if (curr.right != null)
                stack.push(curr.right);
            if (curr.left != null)
                stack.push(curr.left);
        }
        return res;
    }
}
