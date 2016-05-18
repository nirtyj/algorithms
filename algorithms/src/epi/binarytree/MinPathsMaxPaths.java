package epi.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinPathsMaxPaths {

	private static int minPathsMin = Integer.MAX_VALUE;
	private static int maxPathsMAx = Integer.MIN_VALUE;
	private static List<BinaryTreeNode<Integer>> paths = Collections.emptyList();

	public static List<BinaryTreeNode<Integer>> getMinPaths(BinaryTreeNode<Integer> root) {
		if (root != null) {
			ArrayList<BinaryTreeNode<Integer>> result = new ArrayList<>();
			result.add(root);
			recurseHelperMin(root, 0, result);
		}
		return paths;
	}

	private static void recurseHelperMin(BinaryTreeNode<Integer> node, int currentHeight,
			ArrayList<BinaryTreeNode<Integer>> result) {
		if (node.left == null && node.right == null) {
			if (currentHeight < minPathsMin) {
				paths = new ArrayList<BinaryTreeNode<Integer>>(result);
				minPathsMin = currentHeight;
			}
			return;
		}

		if (node.left != null) {
			result.add(node.left);
			recurseHelperMin(node.left, currentHeight + 1, result);
			result.remove(result.size() - 1);
		}

		if (node.right != null) {
			result.add(node.right);
			recurseHelperMin(node.right, currentHeight + 1, result);
			result.remove(result.size() - 1);
		}
	}

	public static List<BinaryTreeNode<Integer>> getMaxPaths(BinaryTreeNode<Integer> root) {
		if (root != null) {
			ArrayList<BinaryTreeNode<Integer>> result = new ArrayList<>();
			result.add(root);
			recurseHelperMax(root, 0, result);
		}
		return paths;
	}

	private static void recurseHelperMax(BinaryTreeNode<Integer> node, int currentHeight,
			ArrayList<BinaryTreeNode<Integer>> result) {
		if (node.left == null && node.right == null) {
			if (currentHeight > maxPathsMAx) {
				paths = new ArrayList<BinaryTreeNode<Integer>>(result);
				maxPathsMAx = currentHeight;
			}
			return;
		}

		if (node.left != null) {
			result.add(node.left);
			recurseHelperMax(node.left, currentHeight + 1, result);
			result.remove(result.size() - 1);
		}

		if (node.right != null) {
			result.add(node.right);
			recurseHelperMax(node.right, currentHeight + 1, result);
			result.remove(result.size() - 1);
		}
	}

}
