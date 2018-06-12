package com.leetcode.trees;

import com.leetcode.common.TreeNode;

/**
437. https://leetcode.com/problems/path-sum-iii/description/
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
*/
public class PathSumIII_437 {
	/**
	 * Leetcode verified
	 * @param tree
	 * @param target
	 * @return
	 */
	public int pathSum(TreeNode tree, int target) {

		if (tree == null)
			return 0;

		int nodeFromCurr = findPaths(tree, 0, target);
		int pathsFromLeft = pathSum(tree.left, target);
		int pathsFromRight = pathSum(tree.right, target);
		return nodeFromCurr + pathsFromLeft + pathsFromRight;
	}

	private static int findPaths(TreeNode tree, int currentTarget, int target) {
		if (tree == null)
			return 0;

		currentTarget = currentTarget + tree.val;
		int totalPath = 0;
		if (currentTarget == target) {
			totalPath++;
		}

		totalPath = totalPath + findPaths(tree.left, currentTarget, target);
		totalPath = totalPath + findPaths(tree.right, currentTarget, target);
		return totalPath;
	}
}
