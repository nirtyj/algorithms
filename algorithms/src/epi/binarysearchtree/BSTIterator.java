package epi.binarysearchtree;

import java.util.Stack;

import epi.binarytree.node.TreeNode;

/**
 * Leetcode verfied
 * @author njaganathan
 */
public class BSTIterator {

	Stack<TreeNode> stack = null;

	// push all the left
	public BSTIterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		if (root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	// for a node you pop, see if you have right node, and push all the left of right node
	/** @return the next smallest number */
	public int next() {
		TreeNode node = stack.pop();
		if (node == null)
			return Integer.MIN_VALUE;
		TreeNode result = node;

		if (node.right != null) {
			node = node.right;
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
		return result.val;
	}
}
