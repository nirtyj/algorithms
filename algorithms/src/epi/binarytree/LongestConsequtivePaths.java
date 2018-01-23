package epi.binarytree;

public class LongestConsequtivePaths {

	/**
	 * Leetcode verified
	 * 
	 * @param root
	 * @return
	 */
	public int longestConsecutive(TreeNode root) {
		if (root == null)
			return 0;
		int[] max = new int[1];
		helper(root, 1, max);
		return max[0];
	}

	private static void helper(TreeNode root, int i, int[] max) {
		if (root == null)
			return;

		max[0] = Math.max(max[0], i);

		if (root.left != null) {
			if (root.left.val == root.val + 1)
				helper(root.left, i + 1, max);
			else
				helper(root.left, 1, max);
		}

		if (root.right != null) {
			if (root.right.val == root.val + 1)
				helper(root.right, i + 1, max);
			else
				helper(root.right, 1, max);
		}
	}

	public static int longestConsecutivePaths(BinaryTreeNode<Integer> root) {
		if (root == null)
			return 0;
		int[] max = new int[1];
		helper(root, 0, max);
		return max[0];
	}

	private static void helper(BinaryTreeNode<Integer> root, int i, int[] max) {

		if (root == null)
			return;

		max[0] = Math.max(max[0], i);

		if (root.left != null) {
			if (root.left.data > root.data)
				helper(root.left, i + 1, max);
			else
				helper(root.left, 0, max);
		}

		if (root.right != null) {
			if (root.right.data > root.data)
				helper(root.right, i + 1, max);
			else
				helper(root.right, 0, max);
		}
	}
}
