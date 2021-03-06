package com.leetcode.graph.unionfind;

/**
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 * <p>
 * The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.
 * <p>
 * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.
 * <p>
 * Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.
 * <p>
 * Example 1:
 * Input: [[1,2], [1,3], [2,3]]
 * Output: [2,3]
 * Explanation: The given undirected graph will be like this:
 * 1
 * / \
 * 2 - 3
 * Example 2:
 * Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * Output: [1,4]
 * Explanation: The given undirected graph will be like this:
 * 5 - 1 - 2
 * |   |
 * 4 - 3
 * Note:
 * The size of the input 2D-array will be between 3 and 1000.
 * Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
 */
public class RedundantConnections_LC684 {

    int[] parent;
    int find(int x){
        if (parent[x] == x){
            return x;
        } else {
            return find(parent[x]);
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int[] result = null;
        for (int i = 0; i < n; i++) {
            int group1 = find(edges[i][0]);
            int group2 = find(edges[i][1]);
            if (group1 != group2){
                parent[group2] = group1; // union
            } else {
                result = new int[] {edges[i][0], edges[i][1]};
            }
        }
        return result;
    }

    /**
     * Leetcode verified
     *
     * @param n
     * @param edges
     * @return
     */
    public int[] findRedundantConnectionDSU(int[][] edges) {
        int[] dsu = new int[edges.length + 1];
        for (int i = 0; i < edges.length + 1; i++)
            dsu[i] = i;

        for (int i = 0; i < edges.length; i++) {
            // find set
            int x = find(edges[i][0], dsu);
            int y = find(edges[i][1], dsu);
            // union but don't make a loopback if both x and y are the same.
            // if x and y are the same, it means they are already connected
            if (x == y) {
                return edges[i];
            }
            dsu[x] = y;
        }
        return null;
    }

    private int find(int x, int[] dsu) {
        if (dsu[x] == x)
            return x;
        else
            return find(dsu[x], dsu);
    }
}
