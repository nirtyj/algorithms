package interviewchallenges;

import java.util.Iterator;
import java.util.Stack;

/* Given a binary tree with an integer on each node:
* e.g.
*        2
*       / \
*      3   4
*     / \
*    1   5
* 
* The output should be 231 + 235 + 24 = 490
*/

class Node {
	Integer val;
	Node left;
	Node right;
}

class TreeSum {

	Integer calculateSum(Node root) {
		int totalVal = recursiveHelper(root, 0);
		return totalVal;
	}

	Integer recursiveHelper(Node root, Integer currVal) {
		if (root == null) {
			return currVal;
		}

		currVal = currVal * 10 + root.val;

		Integer leftVal = 0;
		if (root.left != null)
			leftVal = recursiveHelper(root.left, currVal);

		Integer rightVal = 0;
		if (root.right != null)
			rightVal = recursiveHelper(root.right, currVal);

		return leftVal + rightVal;
	}

}

/*
Binary Tree Iterator For Inorder Traversal
*         2
 *       / \
 *      3   4
 *     / \
 *    1   5
          /\
          6 7
          /\
         8  9
          
*/
class BinaryTreeIterator implements Iterator<Node> {
	Node root;
	Stack<Node> stack = new Stack<>();

	BinaryTreeIterator(Node root) {
		this.root = root;
		stack.push(root);
	}

	public boolean hasNext() {
		return false;
	}

	public Node next() {
		while (root.left != null) {
			stack.push(root);
			root = root.left;
		}
		// finished the iteration
		if (stack.isEmpty())
			return null; // throw exception

		Node top = stack.pop(); // 5

		if (top.right != null) {
			Node node = top;
			stack.push(node.right);
			while (node != null) {
				stack.push(node.left);// 5
				node = node.left;
			}
		}
		return top;
	}
	
	/**
	 * Facebook Onsite 
	 * 1. Behvaioral + coding
	 * 		- Valid paranthesis
	 * 2. Coding
	 * 		- Diamater of binary tree
	 * 		- Mutual Friends Recommendataion
	 * 3. Coding
	 * 		- Merge 2 Interval lists
	 * 4. System Design
	 * 		- Design Webcrawler on 10,000 Bots. 
	 * 5. Coding
	 * 		- Find kth largest element in an array
	 * 		- Find 3 sum equal to zero.
	 */
}