package epi.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLeaves {

	public static List<BinaryTreeNode<Integer>> createListOfLeaves(BinaryTreeNode<Integer> tree) {
		List<BinaryTreeNode<Integer>> list = new ArrayList<>();
		depthFirstTraversal(list, tree);
		return list;
	}

	private static void depthFirstTraversal(List<BinaryTreeNode<Integer>> list, BinaryTreeNode<Integer> tree) {

		if (tree == null)
			return;

		if (tree.left == null && tree.right == null)
			list.add(tree);

		depthFirstTraversal(list, tree.left);
		depthFirstTraversal(list, tree.right);
	}
}
