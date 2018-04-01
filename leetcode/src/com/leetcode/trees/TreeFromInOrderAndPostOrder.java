package com.leetcode.trees;

import com.leetcode.common.TreeNode;

/**
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
*/
public class TreeFromInOrderAndPostOrder {

	/**
	 * Leetcode accepted and verified
	 * @param inorder
	 * @param postorder
	 * @return
	 */
	public static TreeNode buildTree(int[] inorder, int[] postorder) {

		if (inorder == null || postorder == null || inorder.length != postorder.length)
			return null;
		return helper(inorder, 0, inorder.length - 1, postorder, postorder.length - 1);
	}

	private static TreeNode helper(int[] inorder, int i, int j, int[] postorder, int curr) {
		if (j < 0 || i > inorder.length - 1 || curr < 0)
			return null;
		if (i == j)
			return new TreeNode(inorder[i]);

		int val = postorder[curr];
		int index = findinInOrder(inorder, i, j, val);
		if (index == -1)
			return null;

		TreeNode node = new TreeNode(val);
		// next curr for left is push left in postorder based on number of elements to the right of index in inorder
		node.left = helper(inorder, i, index - 1, postorder, curr - (j - index) - 1);
		// next curr for right is the one left of postorder
		node.right = helper(inorder, index + 1, j, postorder, curr - 1);
		return node;
	}

	private static int findinInOrder(int[] inor, int i, int j, int val) {
		for (; i <= j; i++) {
			if (inor[i] == val) {
				return i;
			}
		}
		return -1;
	}
}
