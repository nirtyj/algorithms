package epi.binarytree;

import epi.binarytree.node.BinaryTreeNode;

public class TreeFromInOrderAndPostOrder {

	/**
	 * Leetcode accepted and verified
	 * @param inorder
	 * @param postorder
	 * @return
	 */
	public static BinaryTreeNode<Integer> buildTree(int[] inorder, int[] postorder) {

		if (inorder == null || postorder == null || inorder.length != postorder.length)
			return null;
		return helper(inorder, 0, inorder.length - 1, postorder, postorder.length - 1);
	}

	private static BinaryTreeNode<Integer> helper(int[] inorder, int i, int j, int[] postorder, int curr) {
		if (j < 0 || i > inorder.length - 1 || curr < 0)
			return null;
		if (i == j)
			return new BinaryTreeNode<Integer>(inorder[i]);

		int val = postorder[curr];
		int index = findinInOrder(inorder, i, j, val);
		if (index == -1)
			return null;

		BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(val);
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
