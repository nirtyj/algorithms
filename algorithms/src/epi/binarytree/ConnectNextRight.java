package epi.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import epi.binarytree.node.BinaryTreeNode;

public class ConnectNextRight {

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
