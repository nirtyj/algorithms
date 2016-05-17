package ctc.trees_graphs;

import epi.binarytree.BinaryTreeNode;

public class CheckSubTree {

	public static boolean isSubTree(BinaryTreeNode<Integer> t1, BinaryTreeNode<Integer> t2) {
		if (t1 == null)
			return false;

		if (t1.data == t2.data && checkEqualsTree(t1, t2))
			return true;

		return isSubTree(t1.left, t2) || isSubTree(t1.right, t2);
	}

	private static boolean checkEqualsTree(BinaryTreeNode<Integer> t1, BinaryTreeNode<Integer> t2) {
		if (t1 == null && t2 == null) {
			return true;
		} else if ((t1 != null && t2 == null) || (t1 == null && t2 != null)) {
			return false;
		} else {
			return t1.data == t2.data && checkEqualsTree(t1.left, t2.left) && checkEqualsTree(t1.right, t2.right);
		}
	}
}
