package com.leetcode.trees;

import com.leetcode.common.TreeNode;

/**
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.
*/
public class IsBST {

	/**
	 * Leetcode verified
	 * @param root
	 * @return
	 */
	public boolean isValidBST(TreeNode root) {
		return isBstHelper(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
	}

	private boolean isBstHelper(TreeNode root, double min, double max) {
		if (root == null)
			return true;
		if (root.val > min && root.val < max)
			return isBstHelper(root.left, min, root.val) && isBstHelper(root.right, root.val, max);
		else
			return false;
	}

	/**
	 * Fails for the case of a tree with only root node with value - Integer.MAX_VALUE
	 * @param node
	 * @return
	 */
	public static boolean isBst(TreeNode node) {
		if (node == null)
			return true;
		return isBstHelper(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBstHelper(TreeNode node, int minValue, int maxValue) {
		if (node == null)
			return true;
		else if (node.val < minValue || node.val > maxValue)
			return false;

		return isBstHelper(node.left, minValue, node.val)
				&& isBstHelper(node.right, node.val, maxValue);
	}

	public static boolean isBstFail(TreeNode node) {
		if (node == null)
			return true;

		boolean isLeftBst = isBstFail(node.left);
		boolean isRightBst = isBstFail(node.right);

		boolean check = true;
		if (node.left != null) {
			check = check & node.val > node.left.val;
		}
		if (node.right != null) {
			check = check & node.val < node.right.val;
		}
		return isLeftBst && check && isRightBst;
	}

	public static boolean searchValue(TreeNode node, Integer key) {
		if (node == null)
			return false;
		if (node.val == key)
			return true;
		else if (key < node.val)
			return searchValue(node.left, key);
		else
			return searchValue(node.right, key);
	}
}
