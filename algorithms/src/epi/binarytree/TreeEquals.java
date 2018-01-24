package epi.binarytree;

import epi.binarytree.node.BinaryTreeNode;

public class TreeEquals {

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
