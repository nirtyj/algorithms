package com.leetcode.easy;

import com.leetcode.common.TreeNode;


/**
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.
*/
public class CheckSubTree {

	/**
	 * Leetcode verified
	 * @param t1
	 * @param t2
	 * @return
	 */
	public static boolean isSubTree(TreeNode t1, TreeNode t2) {
		if (t1 == null)
			return false;

		if (t1.val == t2.val && checkEqualsTree(t1, t2))
			return true;

		return isSubTree(t1.left, t2) || isSubTree(t1.right, t2);
	}

	private static boolean checkEqualsTree(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return true;
		} else if ((t1 != null && t2 == null) || (t1 == null && t2 != null)) {
			return false;
		} else {
			return t1.val == t2.val && checkEqualsTree(t1.left, t2.left) && checkEqualsTree(t1.right, t2.right);
		}
	}
}
