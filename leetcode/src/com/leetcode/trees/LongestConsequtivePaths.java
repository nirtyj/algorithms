package com.leetcode.trees;

import com.leetcode.common.TreeNode;

/**
Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,
   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
*/
public class LongestConsequtivePaths {

	/**
	 * Leetcode verified
	 * 
	 * @param root
	 * @return
	 */
	public int longestConsecutive(TreeNode root) {
		if (root == null)
			return 0;
		int[] max = new int[1];
		helper(root, 1, max);
		return max[0];
	}

	private static void helper(TreeNode root, int i, int[] max) {
		if (root == null)
			return;

		max[0] = Math.max(max[0], i);

		if (root.left != null) {
			if (root.left.val == root.val + 1)
				helper(root.left, i + 1, max);
			else
				helper(root.left, 1, max);
		}

		if (root.right != null) {
			if (root.right.val == root.val + 1)
				helper(root.right, i + 1, max);
			else
				helper(root.right, 1, max);
		}
	}
}
