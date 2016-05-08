package epi.binarytree;

public class BinaryTreeToLinkedList {

	/**
	 * Leet code accepted & verified
	 * @param root
	 */
	public void flatten(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		helper(root);
	}

	BinaryTreeNode<Integer> helper(BinaryTreeNode<Integer> root) {
		if (root.left == null && root.right == null)
			return root;

		BinaryTreeNode<Integer> flattendLeft = null, flattendRight = null;

		if (root.left != null)
			flattendLeft = helper(root.left);
		if (root.right != null)
			flattendRight = helper(root.right);

		if (flattendLeft == null)
			root.right = flattendRight;
		else {
			root.right = flattendLeft;
			BinaryTreeNode<Integer> curr = flattendLeft;
			while (curr.right != null) {
				curr = curr.right;
			}
			curr.right = flattendRight;
		}

		root.left = null;
		return root;
	}
}
