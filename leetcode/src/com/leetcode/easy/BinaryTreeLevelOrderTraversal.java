package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.leetcode.common.TreeNode;


/**
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/
public class BinaryTreeLevelOrderTraversal {
	
	/**
	 * Leetcode verified
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null)
			return Collections.emptyList();
		List<List<Integer>> result = new ArrayList<>();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			LinkedList<TreeNode> innerQueue = new LinkedList<TreeNode>();
			ArrayList<Integer> parentInteger = new ArrayList<Integer>();
			for (TreeNode node : queue) {
				parentInteger.add(node.val);
				if (node.left != null) {
					innerQueue.add(node.left);
				}

				if (node.right != null) {
					innerQueue.add(node.right);
				}
			}
			result.add(parentInteger);
			queue = innerQueue;
		}
		return result;
	}
}
