package epi.binarysearchtree;

import epi.binarytree.BinaryTreeNode;
import epi.linkedlist.LinkedListNode;

public class SortedLinkedListToHeightBalanedBST {

	public static BinaryTreeNode<Integer> sortedListToBST(LinkedListNode head) {
		if (head == null)
			return null;
		return helper(head, null);
	}

	private static BinaryTreeNode<Integer> helper(LinkedListNode start, LinkedListNode end) {
		if (start == null)
			return null;

		if (start == end || start.next == null) {
			return new BinaryTreeNode<Integer>(start.data);
		} else if (start.next == end) {
			BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(start.data);
			root.left = new BinaryTreeNode<Integer>(end.data);
			return root;
		}

		LinkedListNode fast = start;
		LinkedListNode slow = start;
		LinkedListNode prev = null;
		while (fast != end && fast.next != end) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		LinkedListNode mid = slow;

		BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(mid.data);
		node.left = helper(start, prev);
		node.right = helper(mid.next, end);
		return node;
	}
}
