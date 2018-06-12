package com.leetcode.trees;

import com.leetcode.common.TreeNode;

/**
101. https://leetcode.com/problems/symmetric-tree/

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
*/
public class SymmetricBinaryTree_101 {

	/**
	 * Leetcode verified. Symmetric is
	 * left of left sub tree equals right of right sub tree 
	 * right of left sub tree equals left of right sub tree
	 * 
	 * @param tree
	 * @return
	 */
	public static boolean isSymmetric(TreeNode tree) {
		return (tree == null || isSymmetricHelper(tree.left, tree.right));
	}

	private static boolean isSymmetricHelper(TreeNode leftSubTree,
			TreeNode rightSubTree) {

		if (leftSubTree == null && rightSubTree == null)
			return true;
		else if (leftSubTree != null && rightSubTree != null) {
			return leftSubTree.val == rightSubTree.val
					&& isSymmetricHelper(leftSubTree.right, rightSubTree.left)
					&& isSymmetricHelper(leftSubTree.left, rightSubTree.right);
		}
		return false;
	}
}
