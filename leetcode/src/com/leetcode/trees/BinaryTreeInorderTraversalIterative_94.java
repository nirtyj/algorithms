package com.leetcode.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.leetcode.common.TreeNode;

/**
94. https://leetcode.com/problems/binary-tree-inorder-traversal/description/
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
*/
public class BinaryTreeInorderTraversalIterative_94 {

	/**
	 * Leetcode verified
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        // for each node go push untill left is null
        // pop the last and add to the result. 
        // switch to right of that node and go as far left as possible in next iteration.
        while (cur != null || !stack.isEmpty()) { 
            while (cur != null) {// Travel to each node's left child, till reach the left leaf
                stack.push(cur);
                cur = cur.left;				
            }		 
            cur = stack.pop(); // Backtrack to higher level node A
            res.add(cur.val);  // Add the node to the result list
            cur = cur.right;   // Switch to A'right branch
        }
        return res;
    }
}
