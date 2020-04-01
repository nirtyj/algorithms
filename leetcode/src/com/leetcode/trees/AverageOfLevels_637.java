package com.leetcode.trees;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 637.https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * Example 1:
 * Input:
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 * Note:
 * The range of node's value is in the range of 32-bit signed integer.
 */
public class AverageOfLevels_637 {

    /**
     * Leetcode verified
     *
     * @param root
     * @return
     */
    public List<Double> averageOfLevelsTwoLoops(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root == null)
            return result;
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            double sum = 0.0;
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
            result.add(sum / n);
        }
        return result;
    }

    /**
     * Leetcode verified
     *
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        List<Double> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        result.add(new Double(root.val));

        while (!queue.isEmpty()) {
            queue = getNextLevelNodes(queue);
            if (queue.size() != 0) {
                Double sum = (double) (0);
                for (TreeNode node : queue) {
                    sum = sum + node.val;
                }
                Double avg = sum / (double) queue.size();
                result.add(avg);
            }
        }

        return result;
    }

    private Queue<TreeNode> getNextLevelNodes(Queue<TreeNode> nodes) {
        Queue<TreeNode> queue = new LinkedList<>();
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        return queue;
    }
}
