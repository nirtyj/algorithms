package epi.binarytree;

public class HasPathSum {

	public static boolean hasPathSum(BinaryTreeNode<Integer> tree, int targetSum) {
		if (tree == null)
			return false;
		return hashPathSumHelper(tree, 0, targetSum);
	}

	private static boolean hashPathSumHelper(BinaryTreeNode<Integer> tree, int currentSum, int targetSum) {
		if (tree == null)
			return false;

		if (currentSum + tree.data == targetSum) {
			if (tree.left == null && tree.right == null)
				return true;
			else
				return false;
		}

		boolean foundLeft = hashPathSumHelper(tree.left, currentSum + tree.data, targetSum);
		if (foundLeft)
			return foundLeft;
		boolean foundRight = hashPathSumHelper(tree.right, currentSum + tree.data, targetSum);
		return foundRight;
	}
}
