package com.leetcode.graph.unionfind;

import com.leetcode.common.DisjointSetUnionWithPathCompression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point may have at most one stone.
 *
 * Now, a move consists of removing a stone that shares a column or row with another stone on the grid.
 *
 * What is the largest possible number of moves we can make?
 *
 *
 *
 * Example 1:
 *
 * Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * Output: 5
 * Example 2:
 *
 * Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
 * Output: 3
 * Example 3:
 *
 * Input: stones = [[0,0]]
 * Output: 0
 */
public class MostStonesRemoved_LC947 {
    int connectedNodes = 0;

    /**
     * Union find - fastest
     */
    public int removeStonesUnionFind(int[][] stones) {
        int N = stones.length;
        DisjointSetUnionWithPathCompression dsu = new DisjointSetUnionWithPathCompression(20000);
        for (int[] stone : stones)
            dsu.union(stone[0], stone[1] + 10000);
        Set<Integer> seen = new HashSet();
        for (int[] stone : stones)
            seen.add(dsu.find(stone[0]));
        return N - seen.size();
    }

    /**
     * DFS
     * @param stones
     * @return
     */
    public int removeStones(int[][] stones) {
        Map<String, List<int[]>> mapping = new HashMap<>();
        for (int[] stone : stones) {
            String rowKey = stone[0] + "|*";
            List<int[]> rowList = mapping.getOrDefault(rowKey, new ArrayList<>());
            rowList.add(stone);
            String colKey = "*|" + stone[1];
            List<int[]> colList = mapping.getOrDefault(colKey, new ArrayList<>());
            colList.add(stone);
            mapping.put(rowKey, rowList);
            mapping.put(colKey, colList);

        }
        Set<int[]> visited = new HashSet<>();
        for (int[] s1 : stones) {
            if (!visited.contains(s1)) {
                dfs(mapping, s1, visited);
                connectedNodes++;
            }
        }
        return stones.length - connectedNodes;
    }

    private void dfs(Map<String, List<int[]>> mapping, int[] s1, Set<int[]> visited) {
        visited.add(s1);
        for (int[] rowItem : mapping.get(s1[0] + "|*")) {
            if (!visited.contains(rowItem)) {
                visited.add(rowItem);
                dfs(mapping, rowItem, visited);
            }
        }
        for (int[] colItem : mapping.get("*|" + s1[1])) {
            if (!visited.contains(colItem)) {
                visited.add(colItem);
                dfs(mapping, colItem, visited);
            }
        }
    }
}
