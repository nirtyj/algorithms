package com.leetcode.graph.bipartite;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an undirected graph, return true if and only if it is bipartite.
 *
 * Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets
 * A and B such that every edge in the graph has one node in A and another node in B.
 *
 * The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes
 * i and j exists.  Each node is an integer between 0 and graph.length - 1.
 * There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.
 *
 * Example 1:
 * Input: [[1,3], [0,2], [1,3], [0,2]]
 * Output: true
 * Explanation:
 * The graph looks like this:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * We can divide the vertices into two groups: {0, 2} and {1, 3}.
 * Example 2:
 * Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * Output: false
 * Explanation:
 * The graph looks like this:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * We cannot find a way to divide the set of nodes into two independent subsets.
 */
public class IsGraphBipartite_LC785 {
    /**
     * Leetcode verified
     * https://www.youtube.com/watch?v=FofydiwP5YQ
     * @param graph
     * @return
     */
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        // Color : 0 => not visited, 1 => blue, -1 => red
        for(int i=0;i< graph.length ;i++){
            q.clear();
            // do bfs only if its not visited
            if (color[i] == 0 && !bfs(graph, color, q, i)){
                return false;
            }
        }
        return true;
    }

    private boolean bfs(int[][] graph, int[] color, Queue<Integer> q, int node){
        // set one color.
        color[node] = 1;
        q.add(node);
        while(!q.isEmpty()){
            int curr = q.poll();
            // visit neighboring nodes
            for (int nei : graph[curr]) {
                // if its the same color return false.
                if (color[nei] == color[curr]) {
                    return false;
                } else if (color[nei] == 0) { // if its not seen, set it to opposite color.
                    color[nei] = -color[curr];
                    q.add(nei);
                }
            }
        }
        return true;
    }
}
