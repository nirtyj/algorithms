package careercup.facebook.others;

import java.util.List;

/**
https://careercup.com/question?id=5067018381295616

Given a binary tree, print the path that has the maximum path sum. 
For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root. the node val may be negative one

For example:
Given the below binary tree,

       1
       / \
     2   3
Return 2-1-3.
       -1
       / \
     -2   3
            \
            -1
Return  3.
*/

public class MaxPathSumBinaryTree {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> findMaxPath(TreeNode root) {
		return null;
	}

}
