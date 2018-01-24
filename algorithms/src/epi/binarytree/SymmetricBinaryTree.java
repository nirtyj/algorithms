package epi.binarytree;

import epi.binarytree.node.BinaryTreeNode;

public class SymmetricBinaryTree {

	/**
	 * Leetcode verified. Symmetric is
	 * left of left sub tree equals right of right sub tree 
	 * right of left sub tree equals left of right sub tree
	 * 
	 * @param tree
	 * @return
	 */
	public static boolean isSymmetric(BinaryTreeNode<Integer> tree) {
		return (tree == null || isSymmetricHelper(tree.getLeft(), tree.getRight()));
	}

	private static boolean isSymmetricHelper(BinaryTreeNode<Integer> leftSubTree,
			BinaryTreeNode<Integer> rightSubTree) {

		if (leftSubTree == null && rightSubTree == null)
			return true;
		else if (leftSubTree != null && rightSubTree != null) {
			return leftSubTree.getData() == rightSubTree.getData()
					&& isSymmetricHelper(leftSubTree.getRight(), rightSubTree.getLeft())
					&& isSymmetricHelper(leftSubTree.getLeft(), rightSubTree.getRight());
		}
		return false;
	}

	/**
	 * Not correct.
	 * 
	 * @param tree
	 * @return
	 */
	public static boolean isSymmetricByPrint(BinaryTreeNode<Integer> tree) {
		return getPrint(tree.getLeft()).equals(getPrint(tree.getRight()));
	}

	private static String getPrint(BinaryTreeNode<Integer> node) {
		if (node == null)
			return "";
		return "(" + "(" + getPrint(node.getLeft()) + ")" + "(" + node.getData() + ")" + "(" + getPrint(node.getRight())
				+ ")" + ")";
	}
}
