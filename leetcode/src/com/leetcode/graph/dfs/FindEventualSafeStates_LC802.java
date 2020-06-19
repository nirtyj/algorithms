package com.leetcode.graph.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * In a directed graph, we start at some node and every turn, walk along a directed edge of the graph.
 * If we reach a node that is terminal (that is, it has no outgoing directed edges), we stop.
 *
 * Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node.
 * ALL PATHS SHOULD REACH THE TERMINAL NODE
 *
 * Which nodes are eventually safe?  Return them as an array in sorted order.
 *
 * The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph.  The graph is given in the following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph.
 *
 * Example:
 * Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 * Output: [2,4,5,6]
 * Here is a diagram of the above graph.
 */
public class FindEventualSafeStates_LC802 {

    /**
     * Leetcode verified
     * @param graph
     * @return
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        int[] states = new int[graph.length];
        for (int i=0;i<graph.length; i++){
            if (dfs(i, states, graph)){
                result.add(i);
            }
        }
        return result;
    }

    // 0 not visited before; 1 visited but unsafe; 2 visited & safe
    boolean dfs(int node, int[] states,int[][] graph){
        if (states[node]>0){
            return states[node] == 2;
        }
        if(graph[node].length == 0){
            states[node] = 2;
            return true;
        }
        states[node] = 1;
        for(int next: graph[node]){
            if (!dfs(next, states, graph)) {
                return false;
            }
        }
        // if code reached here, all of your nexts are true. hence you are true as well.
        states[node] = 2;
        return true;
    }
}
