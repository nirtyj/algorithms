package com.leetcode.graph.shortestpaths;

import java.util.BitSet;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * An undirected, connected graph of N nodes (labeled 0, 1, 2, ..., N-1) is given as graph.
 *
 * graph.length = N, and j != i is in the list graph[i] exactly once, if and only if nodes i and j are connected.
 *
 * Return the length of the shortest path that visits every node. You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,2,3],[0],[0],[0]]
 * Output: 4
 * Explanation: One possible path is [1,0,2,0,3]
 * Example 2:
 *
 * Input: [[1],[0,2,4],[1,3,4],[2],[1,2]]
 * Output: 4
 * Explanation: One possible path is [0,1,4,2,3]
 *
 *
 * Note:
 *
 * 1 <= graph.length <= 12
 * 0 <= graph[i].length < graph.length
 */
public class ShortestPathVisitingAllNodes_LC847 {

    class Tuple{
        BitSet bitMask;
        int curr;
        int cost;

        public Tuple(BitSet bit, int n, int c){
            bitMask = bit;
            curr = n;
            cost = c;
        }

        public boolean equals(Object o){
            Tuple p = (Tuple) o;
            return bitMask.equals(p.bitMask) && curr == p.curr;
            // need curr as this will allow revisiting the same node multiple times
        }

        public int hashCode(){
            return Objects.hash(bitMask, curr); // BFS guarantees only the shortest path will be reached first.
            // so, no need to include that for equals and hashcode. only the paths visited before + current node at
        }
    }

    /**
     * Leetcode verified
     * @param graph
     * @return
     */
    public int shortestPathLength(int[][] graph) {
        int N = graph.length;
        BitSet allNodesVisited = new BitSet(N); // N nodes possible
        allNodesVisited.set(0, N); // set all N nodes to be visited to stop
        Queue<Tuple> queue = new LinkedList<>();
        Set<Tuple> set = new HashSet<>();

        for(int i = 0; i < N; i++){
            BitSet b = new BitSet(N);
            b.set(i);
            Tuple t = new Tuple(b, i, 0);
            set.add(t);
            queue.add(t);
        }

        while(!queue.isEmpty()){
            Tuple curr = queue.remove();
            if(curr.bitMask.equals(allNodesVisited)){
                return curr.cost;
            } else {
                int[] neighbors = graph[curr.curr];
                for(int v : neighbors){
                    BitSet bitMask = (BitSet) curr.bitMask.clone();
                    bitMask.set(v); // set the node as visited + increase the cost
                    Tuple t = new Tuple(bitMask, v, curr.cost + 1);
                    if(!set.contains(t) ){
                        queue.add(t);
                        set.add(t);
                    }
                }
            }
        }
        return -1;
    }
}
