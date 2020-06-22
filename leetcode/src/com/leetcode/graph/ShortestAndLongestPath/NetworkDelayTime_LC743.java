package com.leetcode.graph.ShortestAndLongestPath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

/**
 * There are N network nodes, labelled 1 to N.
 *
 * Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node,
 * v is the target node, and w is the time it takes for a signal to travel from source to target.
 *
 * Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal?
 * If it is impossible, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
 * Output: 2
 *
 *
 * Note:
 *
 * N will be in the range [1, 100].
 * K will be in the range [1, N].
 * The length of times will be in the range [1, 6000].
 * All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.
 */
public class NetworkDelayTime_LC743 {

    /**
     * Leetcode verified
     * @param times
     * @param N
     * @param K
     * @return
     */
    public int networkDelayTime(int[][] times, int N, int K) {
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            List<int[]> list = graph.getOrDefault(edge[0], new ArrayList<>());
            list.add(new int[]{edge[1], edge[2]});
            graph.put(edge[0], list);
        }
        int totalTime = 0;
        HashSet<Integer> totalNodesVisited = new HashSet<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        q.add(new int[]{K, 0});
        while (!q.isEmpty()) {
            int[] node = q.poll();
            if (totalNodesVisited.contains(node[0])) {
                continue;
            }
            totalTime = node[1]; // total time is appended to the next node. so at each level, just set it to result time
            totalNodesVisited.add(node[0]);
            List<int[]> nexts = graph.get(node[0]);
            if (nexts != null) {
                for (int[] next : nexts) {
                    if (totalNodesVisited.contains(next[0])) {
                        continue;
                    }
                    q.add(new int[]{next[0], totalTime + next[1]});
                }
            }
        }
        return totalNodesVisited.size() == N ? totalTime : -1;
    }
}
