package com.leetcode.trees;

import com.leetcode.common.TreeNode;

/**
Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
The path must contain at least one node and does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
*/
public class BinaryTreeMaximumPathSum {

	int maxSum = Integer.MIN_VALUE;

	/**
	 * Leetcode verified
	 * @param root
	 * @return
	 */
	public int maxPathSum(TreeNode root) {
		recurseHelper(root);
		return maxSum;
	}

	public int recurseHelper(TreeNode current) {
		if (current == null)
			return 0;

		Integer leftVal = 0;
		if (current.left != null)
			leftVal = recurseHelper(current.left);

		Integer rightVal = 0;
		if (current.right != null)
			rightVal = recurseHelper(current.right);

		maxSum = Math.max(maxSum, current.val);
		maxSum = Math.max(maxSum, current.val + leftVal);
		maxSum = Math.max(maxSum, current.val + rightVal);
		maxSum = Math.max(maxSum, leftVal + rightVal + current.val);
		return Math.max(leftVal + current.val, Math.max(rightVal + current.val, current.val));
	}
}
