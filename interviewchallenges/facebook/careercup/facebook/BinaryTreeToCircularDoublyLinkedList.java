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

	/*
	 * helper function -- given two list nodes, join them together so the second
	 * immediately follow the first. Sets the .next of the first and the .previous
	 * of the second.
	 */
	public static void join(TreeNode a, TreeNode b) {
		a.right = b;
		b.left = a;
	}

	/*
	 * helper function -- given two circular doubly linked lists, append them and
	 * return the new list.
	 */
	public static TreeNode append(TreeNode a, TreeNode b) {
		// if either is null, return the other
		if (a == null)
			return (b);
		if (b == null)
			return (a);

		// find the LEFT in each using the .previous pointer
		TreeNode aLeft = a.left;
		TreeNode bLeft = b.left;

		// join the two together to make it connected and circular
		join(aLeft, b);
		join(bLeft, a);

		return (a);
	}

	/*
	 * --Recursion-- Given an ordered binary tree, recursively change it into a
	 * circular doubly linked list which is returned.
	 */
	public static TreeNode treeToList(TreeNode root) {
		// base case: empty tree -> empty list
		if (root == null)
			return (null);

		// Recursively do the subtrees (leap of faith!)
		TreeNode aList = treeToList(root.left);
		TreeNode bList = treeToList(root.right);

		// Make the single root node into a list length-1
		// in preparation for the appending
		root.left = root;
		root.right = root;

		// At this point we have three lists, and it's
		// just a matter of appending them together
		// in the right order (aList, root, bList)
		aList = append(aList, root);
		aList = append(aList, bList);

		return (aList);
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
		// tree.treeToList(tree.root);

		treeToList(tree.root);

		// Display the Circular LinkedList
		tree.display(tree.root);
	}

	/**
	 * More iterations
	 */
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

}
