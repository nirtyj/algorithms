package com.leetcode.trees;

import java.util.ArrayList;

import com.leetcode.common.TreeNode;

/**
Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
*/
public class MinimumAbsDifferenceInBST {

	int min = Integer.MAX_VALUE;
	/**
	 * Leetcode verified
	 * @param root
	 * @return
	 */
	public int getMinimumDifference(TreeNode root) {
		min = Integer.MAX_VALUE;
		recurseHelper(root.left, null, root);
		recurseHelper(root.right, root, null);
		return min;
	}

	private void recurseHelper(TreeNode current, TreeNode leftBound, TreeNode rightBound) {
		if (current == null)
			return;

		if (leftBound != null)
			min = Math.min(min, Math.abs(current.val - leftBound.val));

		if (rightBound != null)
			min = Math.min(min, Math.abs(current.val - rightBound.val));

		recurseHelper(current.left, leftBound, current);
		recurseHelper(current.right, current, rightBound);
	}

	/**
	 * Leetcode verified
	 * @param root
	 * @return
	 */
	public int getMinimumDifferenceMoreSpace(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		recurseHelper(root, list);
		int result = Integer.MAX_VALUE;
		for (int i = 1; i < list.size(); i++) {
			int diff = Math.abs(list.get(i - 1) - list.get(i));
			result = Math.min(result, diff);
		}
		return result;
	}

	private void recurseHelper(TreeNode node, ArrayList<Integer> list) {
		if (node == null)
			return;

		if (node.left != null)
			recurseHelper(node.left, list);

		list.add(node.val);

		if (node.right != null)
			recurseHelper(node.right, list);
	}
}
