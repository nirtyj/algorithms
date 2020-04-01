package com.leetcode.trees;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 545. https://leetcode.com/problems/boundary-of-binary-tree/description/
 * <p>
 * Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.
 * <p>
 * Left boundary is defined as the path from root to the left-most node. Right boundary is defined as the path from root to the right-most node. If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees.
 * <p>
 * The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.
 * <p>
 * The right-most node is also defined by the same way with left and right exchanged.
 * <p>
 * Example 1
 * Input:
 * 1
 * \
 * 2
 * / \
 * 3   4
 * <p>
 * Ouput:
 * [1, 3, 4, 2]
 * <p>
 * Explanation:
 * The root doesn't have left subtree, so the root itself is left boundary.
 * The leaves are node 3 and 4.
 * The right boundary are node 1,2,4. Note the anti-clockwise direction means you should output reversed right boundary.
 * So order them in anti-clockwise without duplicates and we have [1,3,4,2].
 * Example 2
 * Input:
 * ____1_____
 * /          \
 * 2            3
 * / \          /
 * 4   5        6
 * / \      / \
 * 7   8    9  10
 * <p>
 * Ouput:
 * [1,2,4,7,8,9,10,6,3]
 * <p>
 * Explanation:
 * The left boundary are node 1,2,4. (4 is the left-most node according to definition)
 * The leaves are node 4,7,8,9,10.
 * The right boundary are node 1,3,6,10. (10 is the right-most node).
 * So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,10,6,3].
 */
public class BoundaryBinaryTree_545 {

    private static void dfsHelper(TreeNode node, ArrayList<Integer> result) {
        if (node.left == null && node.right == null) {
            result.add(node.val);
            return;
        }

        if (node.left != null)
            dfsHelper(node.left, result);

        if (node.right != null)
            dfsHelper(node.right, result);
    }

    /**
     * Verified with leetcode
     *
     * @param tree
     * @return
     */
    public List<Integer> boundaryOfBinaryTree(TreeNode tree) {

        if (tree == null)
            return Collections.emptyList();

        ArrayList<Integer> result = new ArrayList<>();
        TreeNode curr = tree;

        // add root
        result.add(tree.val);

        // visit all left
        curr = curr.left;
        while (curr != null) {
            result.add(curr.val);
            if (curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;

        }

        // remove the left most leaf
        if (result.size() > 1) {
            result.remove(result.size() - 1);
        }

        // skip adding root node - visit all leaves
        if (tree.left != null)
            dfsHelper(tree.left, result);
        if (tree.right != null)
            dfsHelper(tree.right, result);

        ArrayList<Integer> result_temp = new ArrayList<>();
        curr = tree;

        // visit all right
        curr = curr.right;
        while (curr != null) {
            result_temp.add(curr.val);
            if (curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;

        }

        // remove the rightmost leaf - already added
        if (result_temp.size() >= 1) {
            result_temp.remove(result_temp.size() - 1);
        }

        // reverse
        Collections.reverse(result_temp);

        result.addAll(result_temp);
        return result;

    }
}
