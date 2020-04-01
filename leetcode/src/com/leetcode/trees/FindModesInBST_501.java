package com.leetcode.trees;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 501. https://leetcode.com/problems/find-mode-in-binary-search-tree/description/
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * For example:
 * Given BST [1,null,2,2],
 * 1
 * \
 * 2
 * /
 * 2
 * return [2].
 * <p>
 * Note: If a tree has more than one mode, you can return them in any order.
 * <p>
 * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 */
public class FindModesInBST_501 {

    List<Integer> modes = new ArrayList<Integer>();
    int count = 0;
    int newcount = 0;
    Integer prev = null;

    /**
     * Leetcode verified
     *
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        recurse(root);
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++)
            result[i] = modes.get(i);
        return result;
    }

    public void recurse(TreeNode root) {
        if (root == null)
            return;
        recurse(root.left);

        if (prev == null || prev != root.val)
            newcount = 1;
        else if (root.val == prev)
            newcount++;

        if (newcount > count) {
            modes.clear();
            count = newcount;
            modes.add(root.val);
        } else if (newcount == count) {
            modes.add(root.val);
        }
        prev = root.val;
        recurse(root.right);
    }
}
