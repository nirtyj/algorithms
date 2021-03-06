package com.leetcode.trees;

import com.leetcode.common.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 116. https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
 * Given a binary tree
 * <p>
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * Note:
 * <p>
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
 * 1
 * /  \
 * 2    3
 * / \  / \
 * 4  5  6  7
 * After calling your function, the tree should look like:
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \  / \
 * 4->5->6->7 -> NULL
 */
public class ConnectNextRight_116 {

    private static void recurseHelperTreeLink(Queue<TreeLinkNode> queue) {
        Queue<TreeLinkNode> subqueue = new LinkedList<TreeLinkNode>();
        TreeLinkNode prev = null;
        while (!queue.isEmpty()) {
            TreeLinkNode curr = queue.poll();
            if (prev != null) {
                prev.next = curr;
            }
            prev = curr;
            if (curr.left != null)
                subqueue.add(curr.left);
            if (curr.right != null)
                subqueue.add(curr.right);
        }

        if (!subqueue.isEmpty())
            recurseHelperTreeLink(subqueue);
    }

    /**
     * Verified by leetcode
     *
     * @param root
     */
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        root.next = null;
        queue.add(root);
        recurseHelperTreeLink(queue);
    }

}
