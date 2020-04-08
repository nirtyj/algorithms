package com.leetcode.cheapestflights;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// 11 ms
public class CheapestFlightsDijkstra {

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
        Queue<NodePair> queue = new PriorityQueue<NodePair>();
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
                    continue;  // stop from going to the same node with higher value
                queue.offer(new NodePair(next, cost + entry.getValue(), step -1));
            }
            minCost.put(curr, cost);
        }
        return (bestMin == Integer.MAX_VALUE) ? -1 : bestMin;
    }
}
