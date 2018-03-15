package com.leetcode.easy;

import com.leetcode.common.TreeNode;

/**
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.

*/
public class MaximumDepthOfBinaryTree {

	/**
	 * Leetcode verified
	 * @param tree
	 * @return
	 */
	public int maxDepth(TreeNode tree)
	{
		if(tree == null)
			return 0;
		
		return Math.max(maxDepth(tree.left), maxDepth(tree.right)) + 1;		
	}	
}
