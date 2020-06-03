package com.leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given an undirected tree consisting of n vertices numbered from 0 to n-1, which has some apples in their vertices.
 * You spend 1 second to walk over one edge of the tree.
 * Return the minimum time in seconds you have to spend in order to collect all apples in the tree starting at vertex 0
 * and coming back to this vertex.
 *
 * The edges of the undirected tree are given in the array edges, where edges[i] = [fromi, toi] means that exists an
 * edge connecting the vertices fromi and toi. Additionally, there is a boolean array hasApple,
 * where hasApple[i] = true means that vertex i has an apple, otherwise, it does not have any apple.
 *
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,true,true,false]
 * Output: 8
 * Explanation: The figure above represents the given tree where red vertices have an apple.
 * One optimal path to collect all apples is shown by the green arrows.
 */
public class MinimumTimeToCollectAllApplesIn_LC1443 {

    /**
     * O(n) after building treeNodes.
     * @param n
     * @param edges
     * @param hasApple
     * @return
     */
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        buildTree(edges, map);
        Set<Integer> visited = new HashSet<>();
        return dfs(0, map, hasApple, visited);
    }

    private int dfs(int node, Map<Integer, List<Integer>> map, List<Boolean> hasApple, Set<Integer> visited) {
        visited.add(node);
        int res = 0;
        for (int child : map.getOrDefault(node, new LinkedList<>())) {
            if (visited.contains(child)) {
                continue;
            }
            res += dfs(child, map, hasApple, visited);
        }
        // (if its in path of trueApple leaf  or if its the trueAppleLeaf) && not a root node, then double the cost
        if ((res > 0 || hasApple.get(node)) && node != 0){
            res += 2;
        }

        return res;
    }

    private void buildTree(int[][] edges, Map<Integer, List<Integer>> map) {
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            map.putIfAbsent(a, new LinkedList<>());
            map.putIfAbsent(b, new LinkedList<>());
            map.get(a).add(b);
            map.get(b).add(a);
        }
    }
}
