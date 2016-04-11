package interviewchallenges;

import java.util.ArrayList;

public class Factual {

	class Node {
		Node left;
		Node right;
		int value;
		// # of nodes in left sub-tree
		int s;
	}

	/**
	 * 
	 * 		a BST as a representation of a sorted set of ints
			there are n nodes in the tree
			0 <= k < n
	
			    7
			5    8
			index ~ [0 1 2]
			values ~ 5 7 8
			0th value in the tree is 5
			1st value in the tree is 7
			
	 * @param root
	 * @param v
	 * @return
	 */
	boolean check_val_in_tree(Node root, int v) {
		if (root == null)
			return false;

		if (root.value == v)
			return true;
		else if (v < root.value)
			return check_val_in_tree(root.left, v);
		else
			return check_val_in_tree(root.right, v);
	}

	/**
	 *  		  8
			  6      10
			5  7   9
	
			k is 0
			k is 2
			8.s ~ 3
			10.s ~ 1
			5.s 0
			[5, 6,7  8, 9, 10]
	 * @param args
	 */
	// an implementation that cuts out early
	int find_kth_val_in_tree(Node root, int k) {
		if (root == null)
			return -1;

		int remaining = k - root.s;
		if (remaining == 0)
			return root.value;
		else if (remaining < 0)
			return find_kth_val_in_tree(root.left, k);
		else //
			return find_kth_val_in_tree(root.right, remaining - 1);
	}

	int find_kth_val_in_tree_inefficient(Node root, int k) {
		ArrayList<Integer> inorderValues = new ArrayList<Integer>();
		inorder(root, inorderValues);
		return inorderValues.get(k);
	}

	void inorder(Node node, ArrayList<Integer> inorderValues) {
		if (node == null)
			return;
		inorder(node.left, inorderValues);
		inorderValues.add(node.value);
		inorder(node.right, inorderValues);
	}
}
