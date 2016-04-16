package epi.binarytree;

public class SumRootToLeaf {

	int findSumFromRootToLeaf(BinaryTreeNode<Integer> node) {
		return findSumFromRootHelper(node, 0);
	}

	private int findSumFromRootHelper(BinaryTreeNode<Integer> node, int partialSum) {
		if (node == null)
			return 0;

		int sum = node.data * 2 + partialSum;
		if (node.left == null && node.right == null)
			return sum;
		return findSumFromRootHelper(node.left, sum) + findSumFromRootHelper(node.right, sum);
	}
}
