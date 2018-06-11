package com.leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

import com.leetcode.common.TreeNode;

/**
Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:
    2
   / \
  1   3

Output:
1

Example 2: 
Input:
        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7
Output:
7
Note: You may assume the tree (i.e., the given root node) is not NULL.
*/
public class FindBottomLeftTreeValue {

	/**
	 * Leetcode verified
	 * @param root
	 * @return
	 */
	public int findBottomLeftValue(TreeNode root) {
		if ((root.left == null && root.right == null))
			return root.val;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int result = root.val;
		while (!q.isEmpty()) {
			int size = q.size();
			int i = 0;
			while (i < size) {
				TreeNode n = q.poll();
				if (i == 0)
					result = n.val;
				if (n.left != null)
					q.offer(n.left);
				if (n.right != null)
					q.offer(n.right);
				i++;
			}
		}
		return result;
	}
}
