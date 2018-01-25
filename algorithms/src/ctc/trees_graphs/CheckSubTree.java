package ctc.trees_graphs;

import epi.binarytree.node.BinaryTreeNode;

/**
 * Test if a tree is a subtree of another
 * @author njaganathan
 *
 */
public class CheckSubTree {

	/**
	 * Leetcode verified
	 * @param t1
	 * @param t2
	 * @return
	 */
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
