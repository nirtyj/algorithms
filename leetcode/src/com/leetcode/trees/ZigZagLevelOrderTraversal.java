package com.leetcode.trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.leetcode.common.TreeNode;

/**
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/
public class ZigZagLevelOrderTraversal {

	/**
	 * Leetcode verified
	 * @param root
	 * @return
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		LinkedList<TreeNode> q = new LinkedList<>();
		if (root != null)
			q.add(root);
		boolean leftToRight = true;
		while (!q.isEmpty()) {
			List<Integer> temp = new ArrayList<Integer>();
			LinkedList<TreeNode> tempq = new LinkedList<>();
			Iterator<TreeNode> itr = q.iterator();
			while (itr.hasNext()) {
				TreeNode curr = itr.next();
				temp.add(curr.val);
				if (leftToRight == true) {
					if (curr.left != null)
						tempq.addFirst(curr.left);
					if (curr.right != null)
						tempq.addFirst(curr.right);
				} else {
					if (curr.right != null)
						tempq.addFirst(curr.right);
					if (curr.left != null)
						tempq.addFirst(curr.left);
				}
			}
			leftToRight = !leftToRight;
			result.add(temp);
			q = tempq;
		}
		return result;
	}
}
