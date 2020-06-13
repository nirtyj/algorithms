package com.leetcode.graph.bipartite;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
 *
 * Each person may dislike some other people, and they should not go into the same group.
 *
 * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
 *
 * Return true if and only if it is possible to split everyone into two groups in this way.
 *
 *
 *
 * Example 1:
 *
 * Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4], group2 [2,3]
 * Example 2:
 *
 * Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
 * Output: false
 * Example 3:
 *
 * Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * Output: false
 */
public class PossibleBiPartition_LC886 {

    /**
     * Leetcode verified with BFS
     * @param N
     * @param dislikes
     * @return
     */
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] color = new int[N];
        int[][] graph = new int[N][N];
        for (int[] dislike : dislikes) {
            graph[dislike[0] - 1][dislike[1] - 1] = 1;
            graph[dislike[1] - 1][dislike[0] - 1] = 1;
        }
        Queue<Integer> q = new LinkedList<>();
        // Color : 0 => not visited, 1 => blue, -1 => red
        for (int i = 0; i < graph.length; i++) {
            q.clear();
            // do bfs only if its not visited
            if (color[i] == 0 && !bfs(graph, color, q, i)) {
                return false;
            }
        }
        return true;
    }


    private boolean bfs(int[][] graph, int[] color, Queue<Integer> q, int node) {
        // set one color.
        color[node] = 1;
        q.add(node);
        while (!q.isEmpty()) {
            int curr = q.poll();
            // visit neighboring nodes
            for (int nei = 0; nei < graph[curr].length; nei++) {
                if (graph[curr][nei] == 0) {
                    continue;
                }
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
