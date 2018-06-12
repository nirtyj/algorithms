package com.leetcode.trees;

import com.leetcode.common.TreeNode;

/**
543. https://leetcode.com/problems/diameter-of-binary-tree/description/
Given a binary tree, you need to compute the length of the diameter of the tree. 
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
This path may or may not pass through the root.

Same as - Find the distance between the farthest two elements in a binary tree.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
*/
public class DiameterOfBinaryTree_543 {
	
	int max = 0;
	/**
	 * Leetcode verified
	 * @param root
	 * @return
	 */
	public int diameterOfBinaryTree(TreeNode root) {
		maxDepth(root);
		return max;
	}

	private int maxDepth(TreeNode root) {
		if (root == null)
			return 0;

		int left = maxDepth(root.left);
		int right = maxDepth(root.right);

		max = Math.max(max, left + right);

		return Math.max(left, right) + 1;
	}
}
