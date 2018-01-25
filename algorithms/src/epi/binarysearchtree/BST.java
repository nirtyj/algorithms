package epi.binarysearchtree;

import epi.binarytree.node.BinaryTreeNode;
import epi.binarytree.node.TreeNode;

public class BST {

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
	public static boolean isBst(BinaryTreeNode<Integer> node) {
		if (node == null)
			return true;
		return isBstHelper(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBstHelper(BinaryTreeNode<Integer> node, int minValue, int maxValue) {
		if (node == null)
			return true;
		else if (node.getData() < minValue || node.getData() > maxValue)
			return false;

		return isBstHelper(node.getLeft(), minValue, node.getData())
				&& isBstHelper(node.getRight(), node.getData(), maxValue);
	}

	public static boolean isBstFail(BinaryTreeNode<Integer> node) {
		if (node == null)
			return true;

		boolean isLeftBst = isBstFail(node.getLeft());
		boolean isRightBst = isBstFail(node.getRight());

		boolean check = true;
		if (node.getLeft() != null) {
			check = check & node.getData() > node.getLeft().getData();
		}
		if (node.getRight() != null) {
			check = check & node.getData() < node.getRight().getData();
		}
		return isLeftBst && check && isRightBst;
	}

	public static boolean searchValue(BinaryTreeNode<Integer> node, Integer key) {
		if (node == null)
			return false;
		if (node.getData() == key)
			return true;
		else if (key < node.getData())
			return searchValue(node.getLeft(), key);
		else
			return searchValue(node.getRight(), key);
	}
}
