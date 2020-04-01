package com.leetcode.trees;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 113. https://leetcode.com/problems/path-sum-ii/description/
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * <p>
 * For example:
 * Given the below binary tree and sum = 22,
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * return
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class PathSum2_113 {

    /**
     * Leetcode verified
     *
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return Collections.emptyList();

        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        hasPathSumHelper(result, root, sum, current);
        return result;
    }

    public void hasPathSumHelper(List<List<Integer>> result, TreeNode root, int sum, List<Integer> current) {
        if (root == null)
            return;

        if (root.left == null && root.right == null && root.val != sum)
            return;

        if (root.left == null && root.right == null && root.val == sum) {
            current.add(root.val);
            result.add(new ArrayList<>(current));
            current.remove(current.size() - 1);
            return;
        }

        if (root.left != null) {
            current.add(root.val);
            hasPathSumHelper(result, root.left, sum - root.val, current);
            current.remove(current.size() - 1);
        }

        if (root.right != null) {
            current.add(root.val);
            hasPathSumHelper(result, root.right, sum - root.val, current);
            current.remove(current.size() - 1);
        }
    }
}
