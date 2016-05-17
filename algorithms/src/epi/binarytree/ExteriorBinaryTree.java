package epi.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExteriorBinaryTree {

	public static List<BinaryTreeNode<Integer>> exteriorBinaryTree(BinaryTreeNode<Integer> tree) {

		ArrayList<BinaryTreeNode<Integer>> result = new ArrayList<>();
		BinaryTreeNode<Integer> curr = tree;
		
		// add root
		result.add(tree);
		
		// visit all left
		while (curr.left != null) {
			curr = curr.left;
			result.add(curr);
		}

		// remove the left most leaf
		if (result.size() > 1) {
			result.remove(result.size() - 1);
		}

		// skip adding root node - visit all leaves
		if (tree.left != null)
			dfsHelper(tree.left, result);
		if (tree.right != null)
			dfsHelper(tree.right, result);

		ArrayList<BinaryTreeNode<Integer>> result_temp = new ArrayList<>();
		curr = tree;
		// visit all right
		while (curr.right != null) {
			curr = curr.right;
			result_temp.add(curr);
		}
		
		// remove the rightmost leaf - already added
		if (result_temp.size() > 1) {
			result_temp.remove(result_temp.size() - 1);
		}
		
		// reverse
		Collections.reverse(result_temp);
		
		result.addAll(result_temp);
		return result;

	}

	private static void dfsHelper(BinaryTreeNode<Integer> node, ArrayList<BinaryTreeNode<Integer>> result) {
		if (node.left == null && node.right == null) {
			result.add(node);
			return;
		}

		if (node.left != null)
			dfsHelper(node.left, result);

		if (node.right != null)
			dfsHelper(node.right, result);
	}
}
