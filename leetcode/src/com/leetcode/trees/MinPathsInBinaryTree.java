package com.leetcode.trees;

import com.leetcode.common.TreeNode;

/**
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
*/
public class MinPathsInBinaryTree {

	static int minVal = Integer.MAX_VALUE;

	/**
	 * Verified and accepted with leetcode
	 * @param root
	 * @return
	 */
	public static int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		helper(root, 1);
		return minVal;
	}

	public static void helper(TreeNode root, int depth) {
		if (root.left == null && root.right == null) {
			minVal = Math.min(minVal, depth);
			return;
		}

		if (root.left != null)
			helper(root.left, depth + 1);
		if (root.right != null)
			helper(root.right, depth + 1);
	}
}
