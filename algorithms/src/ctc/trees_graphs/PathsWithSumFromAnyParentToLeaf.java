package ctc.trees_graphs;

import epi.binarytree.BinaryTreeNode;

public class PathsWithSumFromAnyParentToLeaf {

	/**
	 * Worst case - n^2
	 * @param tree
	 * @param target
	 * @return
	 */
	public static int findTotalPaths(BinaryTreeNode<Integer> tree, int target) {
		if (tree == null)
			return 0;

		int nodeFromCurr = findPaths(tree, 0, target);
		int pathsFromLeft = findTotalPaths(tree.left, target);
		int pathsFromRight = findTotalPaths(tree.right, target);
		return nodeFromCurr + pathsFromLeft + pathsFromRight;
	}

	private static int findPaths(BinaryTreeNode<Integer> tree, int currentTarget, int target) {
		if (tree == null)
			return 0;

		currentTarget = currentTarget + tree.data;
		int totalPath = 0;
		if (currentTarget == target) {
			totalPath++;
		}

		totalPath = totalPath + findPaths(tree.left, currentTarget, target);
		totalPath = totalPath + findPaths(tree.right, currentTarget, target);
		return totalPath;
	}	
}
