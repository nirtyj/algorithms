package com.leetcode.trees;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DeleteNodesAndReturnForest_LC1110 {

    /**
     * Efficient with swapping of booleans passed down to children.
     * @param root
     * @param to_delete
     * @return
     */
    public List<TreeNode> delNodesEfficient(TreeNode root, int[] to_delete) {
        HashSet<Integer> deleted = new HashSet<>();
        for(int d : to_delete){
            deleted.add(d);
        }
        ArrayList<TreeNode> result = new ArrayList<>();
        visit(root, true, result, deleted); // initialize with default of you need to add
        return result;
    }

    TreeNode visit(TreeNode n, boolean add, ArrayList<TreeNode> result, HashSet<Integer> deleted) {
        if (n == null){
            return null;
        }
        boolean deletedVal = deleted.contains(n.val);
        if (add && !deletedVal){
            result.add(n);
        }
        n.left = visit(n.left, deletedVal, result, deleted); // pass in the deleted Val to say you need to add children if possible
        n.right = visit(n.right, deletedVal, result, deleted); // if the parent is deleted, you need to add children if possible.
        // if the parent is not deleted, you dont need to add the children. so pass deleted/add as false.
        // use same boolean to overload the meaning.
        return deletedVal ? null : n;
    }

    /**
     * Naive
     */
    HashMap<Integer, TreeNode> valToTreeNode = new HashMap<>();
    HashMap<TreeNode, ArrayList<TreeNode>> index = new HashMap<>();
    HashSet<Integer> deleted = new HashSet<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        visit(root);
        for (int d : to_delete) {
            deleted.add(d);
            TreeNode tod = valToTreeNode.get(d);
            index.remove(tod);
        }
        ArrayList<TreeNode> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            if (index.containsKey(n)) {
                result.add(n);
                remove(n);
            }
            if (n.left != null) {
                q.add(n.left);
            }
            if (n.right != null) {
                q.add(n.right);
            }
            if (n.left != null && deleted.contains(n.left.val)) {
                n.left = null;
            }
            if (n.right != null && deleted.contains(n.right.val)) {
                n.right = null;
            }
        }
        return result;
    }

    public void remove(TreeNode root) {
        if (root == null || !index.containsKey(root)) {
            return;
        }
        ArrayList<TreeNode> children = index.get(root);
        index.remove(root);
        for (TreeNode child : children) {
            remove(child);
        }
    }

    public void visit(TreeNode root) {
        if (root == null) {
            return;
        }
        valToTreeNode.put(root.val, root);
        ArrayList<TreeNode> children = index.getOrDefault(root, new ArrayList<TreeNode>());
        if (root.left != null) {
            children.add(root.left);
        }
        if (root.right != null) {
            children.add(root.right);
        }
        index.put(root, children);
        visit(root.left);
        visit(root.right);
    }
}
