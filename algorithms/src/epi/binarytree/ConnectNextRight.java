package epi.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import epi.binarytree.node.BinaryTreeNode;
import epi.binarytree.node.TreeLinkNode;

public class ConnectNextRight {

	/**
	 * Verified by leetcode
	 * 
	 * @param root
	 */
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		root.next = null;
		queue.add(root);
		recurseHelperTreeLink(queue);
	}

	private static void recurseHelperTreeLink(Queue<TreeLinkNode> queue) {
		Queue<TreeLinkNode> subqueue = new LinkedList<TreeLinkNode>();
		TreeLinkNode prev = null;
		while (!queue.isEmpty()) {
			TreeLinkNode curr = queue.poll();
			if (prev != null) {
				prev.next = curr;
			}
			prev = curr;
			if (curr.left != null)
				subqueue.add(curr.left);
			if (curr.right != null)
				subqueue.add(curr.right);
		}

		if (!subqueue.isEmpty())
			recurseHelperTreeLink(subqueue);
	}

	public static void constructRightSibling(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;

		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		queue.add(root);
		recurseHelper(queue);
	}

	private static void recurseHelper(Queue<BinaryTreeNode<Integer>> queue) {
		Queue<BinaryTreeNode<Integer>> subqueue = new LinkedList<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> prev = null;
		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> curr = queue.poll();
			if (prev != null) {
				prev.setSibling(curr);
			}
			prev = curr;
			if (curr.left != null)
				subqueue.add(curr.left);
			if (curr.right != null)
				subqueue.add(curr.right);
		}

		if (!subqueue.isEmpty())
			recurseHelper(subqueue);
	}

	public static void constructRightSiblingRecursive(BinaryTreeNode<Integer> root) {

		if (root == null)
			return;

		BinaryTreeNode<Integer> node = root;
		while (node != null) {
			if (node.left != null) {
				node.left.next = node.right;
			}
			if (node.right != null && node.next != null) {
				node.right.next = node.next.left;
			}
			node = node.next;
		}

		if (root.left != null)
			constructRightSiblingRecursive(root.left);

		if (root.right != null)
			constructRightSiblingRecursive(root.right);
	}

}
