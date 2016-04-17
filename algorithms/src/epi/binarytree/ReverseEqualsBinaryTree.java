package epi.binarytree;

public class ReverseEqualsBinaryTree {

	public static void reverseTree(BinaryTreeNode<Integer> tree) 
	{
		BinaryTreeNode<Integer> temp = tree.left;
		tree.left = tree.right;
		tree.right = temp;
		if (tree.left != null)
			reverseTree(tree.left);

		if (tree.right != null)
			reverseTree(tree.right);
	}

	public static boolean isEqualTrees(BinaryTreeNode<Integer> node1, BinaryTreeNode<Integer> node2)
	{
		if (node1 == null && node2 == null)
			return true;
		else if ((node1 == null && node2 != null) || (node1 != null && node2 == null))
			return false;
		else
			return isEqualTrees(node1.left, node2.left) && node1.data.equals(node2.data)
					&& isEqualTrees(node1.right, node2.right);
	}
}
