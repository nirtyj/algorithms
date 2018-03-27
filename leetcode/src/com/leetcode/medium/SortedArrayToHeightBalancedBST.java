package com.leetcode.medium;

import com.leetcode.common.TreeNode;

/**
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

*/
public class SortedArrayToHeightBalancedBST {

	/**
	 * Leet code verified and accepted
	 * @param nums
	 * @return
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null)
			return null;
		return helper(nums, 0, nums.length - 1);
	}

	private TreeNode helper(int[] nums, int i, int j) {
		if (j < 0 || i > j || i > nums.length - 1)
			return null;

		if (i == j) {
			return new TreeNode(nums[i]);
		}

		int mid = i + (j - i) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = helper(nums, i, mid - 1);
		node.right = helper(nums, mid + 1, j);
		return node;
	}
}