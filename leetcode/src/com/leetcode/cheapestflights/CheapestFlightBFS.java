package com.leetcode.cheapestflights;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

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
public class CheapestFlightBFS { // 11 ms

    static class Node {
        public int name;
        public Map<Node, Integer> neighbors = new HashMap<>();

        Node(int name) {
            this.name = name;
        }
    }

    static class NodePair implements Comparable<NodePair> {
        public Node node;
        public int cost;
        public int step;

        NodePair(Node node,int cost, int step) {
            this.node = node;
            this.cost = cost;
            this.step = step;
        }

        @Override
        public int compareTo(NodePair au){
            return Integer.compare(this.cost, au.cost);
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Node srcNode = null;
        Node dstNode = null;
        Node[] map = new Node[n];
        for (int i = 0; i < n; i++) {
            Node node = new Node(i);
            if (i == src) {
                srcNode = node;
            } else if (i == dst) {
                dstNode = node;
            }
            map[i] = node;
        }

        for (int i = 0; i < flights.length; i++) {
            int startNum = flights[i][0];
            int endNum = flights[i][1];
            int cost = flights[i][2];
            Node startNode = map[startNum];
            Node endNode = map[endNum];
            startNode.neighbors.put(endNode, cost);
        }

        int bestMin = Integer.MAX_VALUE;
        HashMap<Node, Integer> minCost = new HashMap<>();
        Queue<NodePair> queue = new LinkedList<NodePair>();
        queue.add(new NodePair(srcNode, 0, K));
        while(!queue.isEmpty())
        {
            NodePair currPair = queue.poll();
            Node curr = currPair.node;
            int cost = currPair.cost;
            int step = currPair.step;

            if (curr.name == dstNode.name) {
                bestMin = Math.min(bestMin, cost);
            }

            for (Map.Entry<Node, Integer> entry : curr.neighbors.entrySet()) {
                Node next = entry.getKey();
                if (cost + entry.getValue() >= bestMin) // prunning
                    continue;
                if (step <0)
                    continue;
                if (minCost.getOrDefault(next, Integer.MAX_VALUE) < (cost + entry.getValue()))
                    continue; // stop from going to the same node with higher value
                queue.offer(new NodePair(next, cost + entry.getValue(), step -1));
            }
            minCost.put(curr, cost);
        }
        return (bestMin == Integer.MAX_VALUE) ? -1 : bestMin;
    }
}
