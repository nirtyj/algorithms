package epi.binarytree;

public class FindSuccessor {

	public static BinaryTreeNode<Integer> findSuccessor(BinaryTreeNode<Integer> node) {

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
}
