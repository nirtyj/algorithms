package com.leetcode.trees;

import com.leetcode.common.TreeNode;
/**
Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

Note:
A subtree must include all of its descendants.
Here's an example:
    10
    / \
   5  15
  / \   \ 
 1   8   7
The Largest BST Subtree in this case is the highlighted one. 
The return value is the subtree's size, which is 3.
Follow up:
Can you figure out ways to solve it with O(n) time complexity?
*/
public class LargestBSTSubTree {

	private static class NodeData {
		boolean isBst = false;
		int size = 0;
		int small = Integer.MAX_VALUE;
		int big = Integer.MIN_VALUE;

		NodeData(boolean isBst, int size, int big, int small) {
			this.isBst = isBst;
			this.size = size;
			this.big = big;
			this.small = small;
		}
	}

	int max = 0;

	/**
	 * Leetcode verified
	 * @param root
	 * @return
	 */
	public int largestBSTSubtree(TreeNode root) {
		if (root == null)
			return 0;
		postOrder(root);
		return max;
	}

	public NodeData postOrder(TreeNode root) {
		if (root.left == null && root.right == null) {
			max = Math.max(max, 1);
			return new NodeData(true, 1, root.val, root.val);
		}

		NodeData left = null;
		if (root.left != null) {
			left = postOrder(root.left);
		}

		NodeData right = null;
		if (root.right != null) {
			right = postOrder(root.right);
		}

		if (left != null && left.isBst == false)
			return left;
		if (right != null && right.isBst == false)
			return right;

		boolean lefter = (left == null) ? true : (root.val > left.big);
		boolean righter = (right == null) ? true : (root.val < right.small);
		if (lefter && righter) {
			int leftmin = left == null ? root.val : left.small;
			int rightmax = right == null ? root.val : right.big;
			NodeData curr = new NodeData(true,
					((left == null) ? 0 : left.size) + ((right == null) ? 0 : right.size) + 1, rightmax, leftmin);
			max = Math.max(max, curr.size);
			return curr;
		} else {
			NodeData curr = new NodeData(false, 1, root.val, root.val);
			max = Math.max(max, curr.size);
			return curr;
		}
	}
}
