package epi.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import epi.binarytree.node.BinaryTreeNode;
import epi.binarytree.node.TreeNode;

public class HasPathSumFromRootToLeaf {

	/**
	 * Leetcode verified
	 * 
	 * @param root
	 * @param sum
	 * @return
	 */
	public static boolean hasPathSum(BinaryTreeNode<Integer> root, int sum) {
		if (root == null)
			return false;

		if (root.left == null && root.right == null && sum == root.data)
			return true;

		return hasPathSum(root.left, sum - root.data) || hasPathSum(root.right, sum - root.data);
	}

	/**
	 * Leetcode verified
	 * 
	 * @param root
	 * @param sum
	 * @return
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null) {
			return Collections.emptyList();

		}
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> current = new ArrayList<>();
		hasPathSumHelper(result, root, sum, current);
		return result;
	}

	public void hasPathSumHelper(List<List<Integer>> result, TreeNode root, int sum, List<Integer> current) {
		if (root == null)
			return;

		if (root.left == null && root.right == null && root.val != sum)
			return;

		if (root.left == null && root.right == null && root.val == sum) {
			current.add(root.val);
			result.add(new ArrayList<>(current));
			current.remove(current.size() - 1);
			return;
		}

		if (root.left != null) {
			current.add(root.val);
			hasPathSumHelper(result, root.left, sum - root.val, current);
			current.remove(current.size() - 1);
		}

		if (root.right != null) {
			current.add(root.val);
			hasPathSumHelper(result, root.right, sum - root.val, current);
			current.remove(current.size() - 1);
		}
	}

	public static boolean hasPathSumLong(BinaryTreeNode<Integer> tree, int targetSum) {
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
