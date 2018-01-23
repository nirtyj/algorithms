package epi.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InvertBinaryTree {

	/**
	 * Verified with LeetCode
	 * 
	 * @param root
	 * @return
	 */
	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;

		invertTree(root.left);
		invertTree(root.right);

		TreeNode temp = root.right;
		root.right = root.left;
		root.left = temp;

		return root;
	}
	
	/**
	 * With bugs errors
	 * @param root
	 * @return
	 */
	public static List<BinaryTreeNode<Integer>> inverseTree(BinaryTreeNode<Integer> root) {
		if (root == null)
			return Collections.emptyList();

		ArrayList<BinaryTreeNode<Integer>> result = new ArrayList<>();
		recurseHelper(root, null, result);
		return result;

	}

	public static void recurseHelper(BinaryTreeNode<Integer> node, BinaryTreeNode<Integer> parent,
			List<BinaryTreeNode<Integer>> result) {
		if (node == null) {
			return;
		}

		recurseHelper(node.left, node, result);
		recurseHelper(node.right, node, result);

		if (parent != null) {
			if (parent.left == node) {
				node.right = parent;
				parent.left = null;
			} else {
				node.left = parent;
				parent.right = null;
			}
		}
		result.add(node);
	}
}
