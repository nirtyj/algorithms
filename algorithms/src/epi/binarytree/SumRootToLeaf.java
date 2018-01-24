package epi.binarytree;

import epi.binarytree.node.TreeNode;

public class SumRootToLeaf {

	/**
	 * Leetcode verified
	 * @param root
	 * @return
	 */
	public int sumNumbers(TreeNode root) {
		return findSumFromRootHelper(root, 0);
	}

	private int findSumFromRootHelper(TreeNode node, int partialSum) {
		if (node == null)
			return 0;

		int sum = node.val + partialSum;
		if (node.left == null && node.right == null)
			return sum;
		return findSumFromRootHelper(node.left, sum * 10) + findSumFromRootHelper(node.right, sum * 10);
	}
}
