package epi.binarytree;

public class MirrorBinaryTree {

	public static void mirrorTree(BinaryTreeNode<Integer> tree) 
	{
		BinaryTreeNode<Integer> temp = tree.left;
		tree.left = tree.right;
		tree.right = temp;
		if (tree.left != null)
			mirrorTree(tree.left);

		if (tree.right != null)
			mirrorTree(tree.right);
	}
}
