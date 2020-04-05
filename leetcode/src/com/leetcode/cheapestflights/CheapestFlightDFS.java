package com.leetcode.cheapestflights;

import java.util.HashMap;
import java.util.Map;

/**
 * There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.
 *
 * Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.
 *
 * Example 1:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * Output: 200
 * Explanation:
 * The graph looks like this:
 *
 *
 * The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
 * Example 2:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * Output: 500
 * Explanation:
 * The graph looks like this:
 *
 *
 * The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
 * Note:
 *
 * The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
 * The size of flights will be in range [0, n * (n - 1) / 2].
 * The format of each flight will be (src, dst, price).
 * The price of each flight will be in the range [1, 10000].
 * k is in the range of [0, n - 1].
 * There will not be any duplicated flights or self cycles.
 */
public class CheapestFlightDFS {

    static class Node {
        public int name;
        public Map<Node, Integer> neighbors = new HashMap<>();

        Node(int name) {
            this.name = name;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Node srcNode = null;
        Node dstNode = null;
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Node node = new Node(i);
            if (i == src) {
                srcNode = node;
            } else if (i == dst) {
                dstNode = node;
            }
            map.put(i, node);
        }

        for (int i = 0; i < flights.length; i++) {
            int startNum = flights[i][0];
            int endNum = flights[i][1];
            int cost = flights[i][2];
            Node startNode = map.get(startNum);
            Node endNode = map.get(endNum);
            startNode.neighbors.put(endNode, cost);
        }
        Map<Node, Integer> seen = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry : srcNode.neighbors.entrySet()) {
            Node next = entry.getKey();
            if (entry.getValue() >= min) // prunning
                continue;
            int cost = seen.getOrDefault(next, findCost(next, dstNode, K, entry.getValue(), seen, min));
            if (cost == -1)
                continue;
            else
                min = Math.min(min, cost);
        }
        return (min == Integer.MAX_VALUE) ? -1 : min;
    }

    private int findCost(Node curr, Node dst, int k, int total, Map<Node, Integer> seen, int bestMin) {
        if (curr.name == dst.name)
            return total;
        if (k == 0) {
            return -1;
        }
        int min = bestMin;
        for (Map.Entry<Node, Integer> entry : curr.neighbors.entrySet()) {
            Node next = entry.getKey();
            if (total + entry.getValue() >= bestMin) // prunning
                continue;
            int cost = seen.getOrDefault(next, findCost(next, dst, k - 1, total + entry.getValue(), seen, min));
            if (cost == -1) {
                continue;
            } else {
                min = Math.min(min, cost);
            }
        }
        int result = (min == Integer.MAX_VALUE) ? -1 : min;
        seen.put(curr, result);
        return result;
    }
}
