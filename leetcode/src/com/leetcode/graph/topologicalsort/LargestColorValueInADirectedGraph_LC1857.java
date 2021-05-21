package com.leetcode.graph.topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Topological sort + DP to keep track of maximum.
 */
public class LargestColorValueInADirectedGraph_LC1857 {

    /**
     * build graph.
     * Khan's algorithm
     * Keep a DP to update the max value
     * @param colors
     * @param edges
     * @return
     */
    public int largestPathValue(String colors, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[colors.length()];
        for (int i = 0; i < colors.length(); i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            graph.get(e[0]).add(e[1]);
            inDegree[e[1]]++;
        }
        return topologicalSortUtil(graph, inDegree, colors);
    }

    private Integer topologicalSortUtil(Map<Integer, List<Integer>> graph, int[] indegree, String colors) {
        char[] colorsArr = colors.toCharArray();
        Queue<Integer> queue = new LinkedList<>();
        int[][] map = new int[colors.length()][26];

        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            if (indegree[entry.getKey()] == 0) {
                queue.add(entry.getKey());
                map[entry.getKey()][colorsArr[entry.getKey()] - 'a'] = 1;
            }
        }

        int seen = 0;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            seen++;
            for (int neighbor : graph.get(node)) {
                indegree[neighbor]--;
                // update the map of next node
                for (int i = 0; i < 26; i++) {
                    map[neighbor][i] = Math.max(map[neighbor][i], map[node][i] + (colorsArr[neighbor] - 'a' == i ? 1 : 0));
                }
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (seen != colors.length()) {
            return -1;
        }
        // find the max
        int resultVal = -1;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                resultVal = Math.max(resultVal, map[i][j]);
            }
        }
        return resultVal;
    }
}
