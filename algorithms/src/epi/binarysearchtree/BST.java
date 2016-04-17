package epi.binarysearchtree;

import epi.binarytree.BinaryTreeNode;

public class BST {

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
