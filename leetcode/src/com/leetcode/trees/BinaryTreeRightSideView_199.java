package com.leetcode.trees;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 199. https://leetcode.com/problems/binary-tree-right-side-view/description/
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 * <p>
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 */
public class BinaryTreeRightSideView_199 {

    /**
     * Leetcode verified
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode n = q.getLast();
            result.add(n.val);
            int size = q.size();
            int i = 0;
            while (i < size) {
                TreeNode node = q.pollLast();
                if (node.right != null)
                    q.addFirst(node.right);
                if (node.left != null)
                    q.addFirst(node.left);
                i++;
            }
        }
        return result;
    }
}
