package epi.binarytree;

public class FindSuccessorInBST {

	public static BinaryTreeNode<Integer> findSuccessorWithParent(BinaryTreeNode<Integer> node) {

		if (node == null)
			return null;

		if (node.right != null) {
			BinaryTreeNode<Integer> sucessor = node.right;
			while (sucessor.left != null) {
				sucessor = sucessor.left;
			}
			return sucessor;
		} else {
			BinaryTreeNode<Integer> curr = node;
			BinaryTreeNode<Integer> root = node.parent;
			while (root != null && root.right == curr) {
				curr = root;
				root = root.parent;
			}

			return root;
		}
	}

	public static BinaryTreeNode<Integer> findSuccessor(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> p) {

		if(root == null)
			return null;
		
		BinaryTreeNode<Integer> next = null;
		BinaryTreeNode<Integer> c = root;

		while (c != null && c.data != p.data) {
			// when you go left, update the next
			if (c.data > p.data) {
				next = c;
				c = c.left;
			} else {
				c = c.right;
			}
		}

		if (c == null)
			return null;

		// if you don't have a right subtree, return your parent
		if (c.right == null)
			return next;

		// if you have a right subtree, find the left most element
		c = c.right;
		while (c != null)
			c = c.left;

		return c;
	}
}
