package com.leetcode.trees;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;

/**
 * 653. https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
 * <p>
 * Example 1:
 * Input:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 9
 * <p>
 * Output: True
 * Example 2:
 * Input:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 28
 * <p>
 * Output: False
 */
public class TwoSumIVInputIsBST_653 {

    /**
     * Leetcode verified - O(n) + O(n)
     *
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        recurseHelper(root, list);
        boolean result = false;
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            int sum = list.get(i) + list.get(j);
            if (sum == k)
                return true;
            else if (sum < k)
                i++;
            else
                j--;
        }
        return result;
    }

    private void recurseHelper(TreeNode node, ArrayList<Integer> list) {
        if (node == null)
            return;

        if (node.left != null)
            recurseHelper(node.left, list);

        list.add(node.val);

        if (node.right != null)
            recurseHelper(node.right, list);
    }


    // DFS each node, and try to search the target 'node' such that 'node'.val =
    // k-node.val
    // make sure you don't pick the node itself, like if k = 2 and node.val = 1,
    // don't return node itself!
    public boolean findTargetNew(TreeNode root, int k) {
        return dfs(root, root, k);
    }

    public boolean dfs(TreeNode root, TreeNode cur, int k) {
        if (cur == null)
            return false;
        // search for this node, or find target for other nodes
        return search(root, cur, k - cur.val) || dfs(root, cur.left, k) || dfs(root, cur.right, k);
    }

    public boolean search(TreeNode root, TreeNode cur, int value) {
        if (root == null)
            return false;
        return (root.val == value) && (root != cur) || (root.val < value) && search(root.right, cur, value)
                || (root.val > value) && search(root.left, cur, value);
    }
}
