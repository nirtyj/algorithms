package epi.binarytree;

import epi.binarytree.node.TreeNode;

/**
 * https://careercup.com/question?id=4810205125672960 Given two tree nodes and
 * the root of a tree, find the distance between both nodes in the tree.
 */
public class DistanceBtwnTwoNodes {

	public int findDistance(TreeNode root, TreeNode n1, TreeNode n2) {
		int x = pathlength(root, n1) - 1;
		int y = pathlength(root, n2) - 1;
		TreeNode lcaData = lowestCommonAncestor(root, n1, n2);
		int lcaDistance = pathlength(root, lcaData) - 1;
		return (x + y) - 2 * lcaDistance;
	}

	public int pathlength(TreeNode root, TreeNode n1) {
		if (root == null)
			return 0;	
		int x = 0;
		if ((root.val == n1.val) || (x = pathlength(root.left, n1)) > 0 || (x = pathlength(root.right, n1)) > 0) {
			return x + 1;
		}
		return 0;
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q)
			return root;

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left != null && right != null)
			return root;

		return left == null ? right : left;
	}
}
