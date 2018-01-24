package epi.binarytree;

import epi.binarytree.node.TreeNode;

public class InvertBinaryTree {

	/**
	 * Verified with LeetCode
	 * 
	 * @param root
	 * @return
	 */
	public static TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;

		invertTree(root.left);
		invertTree(root.right);

		TreeNode temp = root.right;
		root.right = root.left;
		root.left = temp;

		return root;
	}
}
