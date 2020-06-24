package com.leetcode.graph.primsandkruskals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * There are N cities numbered from 1 to N.
 *
 * You are given connections, where each connections[i] = [city1, city2, cost] represents the cost to connect city1 and city2 together.  (A connection is bidirectional: connecting city1 and city2 is the same as connecting city2 and city1.)
 *
 * Return the minimum cost so that for every pair of cities, there exists a path of connections (possibly of length 1) that connects those two cities together.  The cost is the sum of the connection costs used. If the task is impossible, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: N = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
 * Output: 6
 * Explanation:
 * Choosing any 2 edges will connect all cities so we choose the minimum 2.
 * Example 2:
 *
 *
 *
 * Input: N = 4, connections = [[1,2,3],[3,4,4]]
 * Output: -1
 * Explanation:
 * There is no way to connect all cities even if all edges are used.
 *
 *
 * Note:
 *
 * 1 <= N <= 10000
 * 1 <= connections.length <= 10000
 * 1 <= connections[i][0], connections[i][1] <= N
 * 0 <= connections[i][2] <= 10^5
 * connections[i][0] != connections[i][1]
 */
public class ConnectingCitiesWithMinimumCost_LC1135 {

    /**
     * Prim's Minimum spanning tree.
     * @param N
     * @param connections
     * @return
     */
    public int minimumCost(int N, int[][] connections) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] conn : connections){
            graph.computeIfAbsent(conn[0], (k) -> new ArrayList<>());
            graph.computeIfAbsent(conn[1], (k) -> new ArrayList<>());
            graph.get(conn[0]).add(new int[]{conn[1], conn[2]});
            graph.get(conn[1]).add(new int[]{conn[0], conn[2]});
        }
        Queue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        q.add(new int[]{1, 0});
        int cost = 0;
        HashSet<Integer> visited = new HashSet<>();
        while(!q.isEmpty()){
            int[] node = q.poll();
            if (!visited.contains(node[0])){
                visited.add(node[0]);
                cost = cost + node[1];
                if (visited.size() == N){
                    break;
                }
                for(int[] neighbor : graph.get(node[0])){
                    if (!visited.contains(neighbor[0])){
                        q.offer(new int[]{neighbor[0], neighbor[1]});
                    }
                }
            }
        }
        return visited.size() == N ? cost : -1;
    }

    /**
     * Kruskals minimum spanning tree
     */

    class KruskalsAlgorithm {

        int total; // total connected groups
        int[] parent;

        int find(int x){
            int root = x;
            while(root != parent[root]){
                root = parent[root];
            }
            while(x != root){
                int up = parent[x];
                parent[x] = root;
                x = up;
            }
            return root;
        }

        void union(int x, int y){
            int parentX = find(x);
            int parentY = find(y);
            if (parentX != parentY){
                parent[parentX] = parentY;
                total--; // Reduce the total element group. you need only 1 group to say all are connected.
                return;
            }
        }

        public int minimumCost(int N, int[][] connections) {
            total = N;
            parent = IntStream.range(0, N+1).toArray();
            Arrays.sort(connections, (a, b) -> Integer.compare(a[2], b[2]));
            int cost = 0;
            for(int[] conn : connections){
                if (find(conn[0]) != find(conn[1])){
                    union(conn[0], conn[1]);
                    cost = cost + conn[2];
                    if (total == 1){
                        break;
                    }
                }
            }
            return total == 1 ? cost : -1;
        }
    }
}
