package com.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * For an undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.
 *
 * Format
 * The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).
 *
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 *
 * Example 1 :
 *
 * Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 *
 *         0
 *         |
 *         1
 *        / \
 *       2   3
 *
 * Output: [1]
 * Example 2 :
 *
 * Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 *
 *      0  1  2
 *       \ | /
 *         3
 *         |
 *         4
 *         |
 *         5
 *
 * Output: [3, 4]
 * Note:
 *
 * According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
 * The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 */
public class MinimumHeightTrees_LC310 {

    /**
     * Leetcode verified. Go from outside of the graph to inside by removing the connections slowly.
     * https://leetcode.com/problems/minimum-height-trees/discuss/76055/Share-some-thoughts/79475
     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1){
            return Arrays.asList(0);
        }
        Map<Integer, HashSet<Integer>> g = new HashMap<>();
        for(int[] edge : edges){
            g.computeIfAbsent(edge[0], (k) -> new HashSet<>());
            g.computeIfAbsent(edge[1], (k) -> new HashSet<>());
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        // find the leaves
        for(Map.Entry<Integer, HashSet<Integer>> entry : g.entrySet()){
            if (entry.getValue().size() ==1){
                leaves.add(entry.getKey());
            }
        }
        while(n > 2){
            List<Integer> newLeaves = new ArrayList<>();
            for(Integer leaf: leaves){
                Integer parent = g.get(leaf).iterator().next();
                g.remove(leaf);
                n = n - 1;
                HashSet<Integer> parentConn = g.get(parent);
                parentConn.remove(leaf);
                if (parentConn.size() == 1){
                    newLeaves.add(parent);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
