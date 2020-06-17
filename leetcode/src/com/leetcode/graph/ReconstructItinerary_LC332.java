package com.leetcode.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to],
 * reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK.
 * Thus, the itinerary must begin with JFK.
 *
 * Note:
 *
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest
 * lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller
 * lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * One must use all the tickets once and only once.
 * Example 1:
 *
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * Example 2:
 *
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 *              But it is larger in lexical order.
 */
public class ReconstructItinerary_LC332 {

    /**
     *  reverse-post-order
     *  void dfs(s) {
     *     for all the neighbors of s:
     *         dfs(n)
     *     route.add(s)
     *  }
     *
     *  Hierholzer’s Algorithm
     *  Eulerian path vs circuit
     *  Hamiltonian Path
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(List<String> ticket : tickets) {
            PriorityQueue<String> tos = map.getOrDefault(ticket.get(0), new PriorityQueue<String>());
            tos.add(ticket.get(1));
            map.put(ticket.get(0), tos);
        }
        LinkedList<String> result = new LinkedList<>();
        recurseHelper(map, result, "JFK");
        return result;
    }

    public void recurseHelper(Map<String, PriorityQueue<String>> map, LinkedList<String> result, String from){
        // Reverse post order traversal in Graph for depth first.
        // visit and remove all next's before adding yourself before.
        while(map.containsKey(from) && !map.get(from).isEmpty()){
            recurseHelper(map, result, map.get(from).poll());
        }
        result.add(0, from);
    }
}
