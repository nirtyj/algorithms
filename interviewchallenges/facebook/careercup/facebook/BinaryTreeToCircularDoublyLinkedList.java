package careercup.facebook;

/**
 * https://careercup.com/question?id=5647428341465088 4.1 binary tree to
 * circular double linked list.
 */

public class BinaryTreeToCircularDoublyLinkedList {
	static class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
			left = right = null;
		}
	}

	public TreeNode solve(TreeNode root) {
		if (root == null) {
			return null;
		}
		convert(root);
		connectHeadAndTail(root);
		return root;
	}

	public void convert(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			TreeNode left = root.left;
			convert(left);
			while (left.right != null) {
				left = left.right;
			}
			left.right = root;
			root.left = left;
		}
		if (root.right != null) {
			TreeNode right = root.right;
			convert(right);
			while (right.left != null) {
				right = right.left;
			}
			right.left = root;
			root.right = right;
		}
	}

	public void connectHeadAndTail(TreeNode root) {
		TreeNode head = root;
		while (head.left != null) {
			head = head.left;
		}
		TreeNode tail = root;
		while (tail.right != null) {
			tail = tail.right;
		}
		head.left = tail;
		tail.right = head;
	}

	TreeNode root;

	public BinaryTreeToCircularDoublyLinkedList() {
		root = null;
	}

	// Display Circular Link List
	public void display(TreeNode head) {
		System.out.println("Circular Linked List is :");
		TreeNode itr = head;
		do {
			System.out.print(itr.val + " ");
			itr = itr.right;
		} while (itr != head);
		System.out.println();
	}

	public static void main(String args[]) {
		// Build the tree
		BinaryTreeToCircularDoublyLinkedList tree = new BinaryTreeToCircularDoublyLinkedList();
		tree.root = new TreeNode(10);
		tree.root.left = new TreeNode(12);
		tree.root.right = new TreeNode(15);
		tree.root.left.left = new TreeNode(25);
		tree.root.left.right = new TreeNode(30);
		tree.root.right.left = new TreeNode(36);

		// head refers to the head of the Link List
		tree.solve(tree.root);

		// Display the Circular LinkedList
		tree.display(tree.root);
	}
}
