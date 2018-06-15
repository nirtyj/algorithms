package com.leetcode.trees;

import com.leetcode.common.TreeNode;

/**
538. https://leetcode.com/problems/convert-bst-to-greater-tree/description/
Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
 */
public class ConvertBSTtoGreaterTree_538 {

	/**
	 * Leetcode verified - O(n)
	 * @param root
	 * @return
	 */
	public TreeNode convertBST(TreeNode root) {
		if (root == null)
			return null;
		recurse(root);
		return root;
	}

	int sum = 0;

	private void recurse(TreeNode root) {
		if (root == null)
			return;
		if (root.right != null)
			recurse(root.right);
		root.val = root.val + sum;
		sum = root.val;
		if (root.left != null)
			recurse(root.left);
	}

	/**
	 * Leetcode verified - O(n*2)
	 * @param root
	 * @return
	 */
	public TreeNode convertBSTSlow(TreeNode root) {
		if (root == null)
			return null;
		recurse(root, 0);
		return root;
	}

	private void recurse(TreeNode root, int parent) {
		if (root == null)
			return;
		int rightSum = findSum(root.right);
		root.val = root.val + rightSum + parent;
		if (root.right != null)
			recurse(root.right, parent);
		if (root.left != null)
			recurse(root.left, root.val);
	}

	private int findSum(TreeNode root) {
		if (root == null)
			return 0;
		int left = 0;
		if (root.left != null)
			left = findSum(root.left);
		int right = 0;
		if (root.right != null)
			right = findSum(root.right);
		return root.val + left + right;
	}
}
