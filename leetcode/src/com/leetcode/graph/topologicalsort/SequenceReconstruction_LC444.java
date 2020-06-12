package com.leetcode.graph.topologicalsort;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs.
 * The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 104.
 * Reconstruction means building a shortest common supersequence of the sequences in seqs
 * (i.e., a shortest sequence so that all sequences in seqs are subsequences of it).
 * Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: org = [1,2,3], seqs = [[1,2],[1,3]]
 * Output: false
 * Explanation: [1,2,3] is not the only one sequence that can be reconstructed, because [1,3,2]
 * is also a valid sequence that can be reconstructed.
 * Example 2:
 * <p>
 * Input: org = [1,2,3], seqs = [[1,2]]
 * Output: false
 * Explanation: The reconstructed sequence can only be [1,2].
 * Example 3:
 * <p>
 * Input: org = [1,2,3], seqs = [[1,2],[1,3],[2,3]]
 * Output: true
 * Explanation: The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].
 * Example 4:
 * <p>
 * Input: org = [4,1,5,2,6,3], seqs = [[5,2,6,3],[4,1,5,2]]
 * Output: true
 */
public class SequenceReconstruction_LC444 {

    /**
     * Breadth first - Topological sort with indegree map
     * @param org
     * @param seqs
     * @return
     */
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if (seqs.size() <= 0) {
            return false;
        }

        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> indegree = new HashMap<>();

        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                graph.putIfAbsent(seq.get(i), new HashSet<>());
                indegree.putIfAbsent(seq.get(i), 0);
                // only for v's having incoming edge & that has not have been processed before
                if (i > 0 && !graph.get(seq.get(i - 1)).contains(seq.get(i))) {
                    indegree.put(seq.get(i), indegree.get(seq.get(i)) + 1);
                    graph.get(seq.get(i - 1)).add(seq.get(i));
                }
            }
        }

        // corner case where no additional vertices present in graph with other than whats in org array.
        if (graph.size() != org.length) {
            return false;
        }

        Queue<Integer> q = new LinkedList<>();
        // add the nodes with no incoming edges - Khan's algorithm for topological sort
        // https://www.youtube.com/watch?v=tFpvX8T0-Pw
        for (Integer in : indegree.keySet()) {
            if (indegree.get(in) == 0) {
                q.add(in);
            }
        }

        int index = 0;
        while (!q.isEmpty()) {
            // more than 1 choice to choose from
            if (q.size() > 1) {
                return false;
            }
            Integer v = q.poll();
            // not the right vertex or out of bounds
            if (index >= org.length || org[index] != v) {
                return false;
            }
            for (Integer nextNode : graph.get(v)) {
                int ins = indegree.get(nextNode);
                ins--;
                indegree.put(nextNode, ins);
                // add only the nodes that doesnt have any incoming edges to the queue
                if (ins == 0) {
                    q.add(nextNode);
                }
            }
            index++;
        }
        // check if the original array is reconstructed
        return (index == org.length);
    }
}
