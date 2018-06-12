package com.leetcode.trees;

import com.leetcode.common.TreeNode;

/**
654. https://leetcode.com/problems/maximum-binary-tree/description/
Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
*/
public class ConstructMaximumBinaryTree_654 {

	/**
	 * Leetcode verified
	 * @param nums
	 * @return
	 */
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;
		return recurse(nums, 0, nums.length - 1);
	}

	private TreeNode recurse(int[] nums, int left, int right) {
		if (left == right)
			return new TreeNode(nums[left]);
		int maxIndex = findMaxIndex(nums, left, right);
		TreeNode node = new TreeNode(nums[maxIndex]);
		if (maxIndex - 1 >= left)
			node.left = recurse(nums, left, maxIndex - 1);
		if (maxIndex + 1 <= right)
			node.right = recurse(nums, maxIndex + 1, right);
		return node;
	}

	private int findMaxIndex(int[] nums, int left, int right) {
		int maxIndex = right;
		int maxValue = nums[right];
		while (left <= right) {
			if (nums[left] > maxValue) {
				maxValue = nums[left];
				maxIndex = left;
			}
			left++;
		}
		return maxIndex;
	}
}
