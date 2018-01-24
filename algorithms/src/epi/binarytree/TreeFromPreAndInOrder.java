package epi.binarytree;

import epi.binarytree.node.BinaryTreeNode;

public class TreeFromPreAndInOrder {

	/**
	 * Leetcode accepted and verified
	 * @param inorder
	 * @param postorder
	 * @return
	 */
	public BinaryTreeNode<Integer> buildTree(int[] preorder, int[] inorder) {

		if (inorder == null || preorder == null || inorder.length != preorder.length)
			return null;
		return helper(inorder, 0, inorder.length - 1, preorder, 0);
	}

	private static BinaryTreeNode<Integer> helper(int[] inorder, int i, int j, int[] preorder, int curr) {
		if (j < 0 || i > inorder.length - 1 || curr >= preorder.length)
			return null;
		if (i == j)
			return new BinaryTreeNode<Integer>(inorder[i]);

		int val = preorder[curr];
		int index = findinInOrder(inorder, i, j, val);
		if (index == -1)
			return null;

		BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(val);
		node.left = helper(inorder, i, index - 1, preorder, curr + 1);
		node.right = helper(inorder, index + 1, j, preorder, curr + 1 + (index - i));

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
