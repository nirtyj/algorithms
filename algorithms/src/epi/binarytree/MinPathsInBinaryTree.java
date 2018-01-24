package epi.binarytree;

import epi.binarytree.node.BinaryTreeNode;

public class MinPathsInBinaryTree {

	static int minVal = Integer.MAX_VALUE;

	/**
	 * Verified and accepted with leetcode
	 * @param root
	 * @return
	 */
	public static int minDepth(BinaryTreeNode<Integer> root) {
		if (root == null)
			return 0;
		helper(root, 1);
		return minVal;
	}

	public static void helper(BinaryTreeNode<Integer> root, int depth) {
		if (root.left == null && root.right == null) {
			minVal = Math.min(minVal, depth);
			return;
		}

		if (root.left != null)
			helper(root.left, depth + 1);
		if (root.right != null)
			helper(root.right, depth + 1);
	}
}
