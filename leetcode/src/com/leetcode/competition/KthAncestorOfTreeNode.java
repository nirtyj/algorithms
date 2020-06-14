package com.leetcode.competition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * You are given a tree with n nodes numbered from 0 to n-1 in the form of a parent array where parent[i]
 * is the parent of node i. The root of the tree is node 0.
 *
 * Implement the function getKthAncestor(int node, int k) to return the k-th ancestor of the given node.
 * If there is no such ancestor, return -1.
 *
 * The k-th ancestor of a tree node is the k-th node in the path from that node to the root.
 * Input:
 * ["TreeAncestor","getKthAncestor","getKthAncestor","getKthAncestor"]
 * [[7,[-1,0,0,1,1,2,2]],[3,1],[5,2],[6,3]]
 *
 * Output:
 * [null,1,0,-1]
 *
 * Explanation:
 * TreeAncestor treeAncestor = new TreeAncestor(7, [-1, 0, 0, 1, 1, 2, 2]);
 *
 * treeAncestor.getKthAncestor(3, 1);  // returns 1 which is the parent of 3
 * treeAncestor.getKthAncestor(5, 2);  // returns 0 which is the grandparent of 5
 * treeAncestor.getKthAncestor(6, 3);  // returns -1 because there is no such ancestor
 *
 */
public class KthAncestorOfTreeNode {

    // Time limit exceeded O(n) construction; O(1) lookup
    int[] parent;
    int n;
    HashMap<Integer, List<Integer>> cache = new HashMap<>();
    public KthAncestorOfTreeNode(int n, int[] parent) {
        this.n = n;
        this.parent = parent;
        this.cache.put(0, Collections.emptyList());
        for(int i=parent.length -1; i>=1;i--){
            if (!cache.containsKey(i)){
                ArrayList<Integer> list = new ArrayList<>();
                getparents(parent[i], list);
                cache.put(i, list);
            }
        }
    }

    public void getparents(int node, List<Integer> list) {
        if (cache.containsKey(node)){
            list.add(node);
            list.addAll(cache.get(node));
            return;
        }
        list.add(node);
        if (node == 0){
            return;
        }
        ArrayList<Integer> newList = new ArrayList<>();
        getparents(parent[node], newList);
        cache.put(node, newList);
        list.addAll(newList);
    }

    public int getKthAncestor(int node, int k) {
        if (node >= parent.length || (node == 0 && k > 0)) {
            return -1;
        }
        if (k == 0){
            return node;
        }
        List<Integer> parentsList = this.cache.get(node);
        if (k > parentsList.size()){
            return -1;
        }
        else {
            return parentsList.get(k-1);
        }
    }

    public static void main(String[] args){
        int[] arr = {-1,0,0,1,1,2,2};
        KthAncestorOfTreeNode k = new KthAncestorOfTreeNode(7 ,arr);
        k.getKthAncestor(3,1);
    }
}
