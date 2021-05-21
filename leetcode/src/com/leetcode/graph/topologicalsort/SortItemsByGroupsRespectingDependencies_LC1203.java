package com.leetcode.graph.topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SortItemsByGroupsRespectingDependencies_LC1203 {
    Map<Integer, List<Integer>> groupGraph;
    Map<Integer, List<Integer>> itemGraph;

    int[] groupsIndegree;
    int[] itemsIndegree;

    private void buildGraphOfGroups(int[] group, List<List<Integer>> beforeItems, int n) {
        for (int i = 0; i < group.length; i++) {
            int toGroup = group[i];
            List<Integer> fromItems = beforeItems.get(i);
            for (int fromItem : fromItems) {
                int fromGroup = group[fromItem];
                if (fromGroup != toGroup) {
                    groupGraph.computeIfAbsent(fromGroup, x -> new ArrayList()).add(toGroup);
                    groupsIndegree[toGroup]++;
                }
            }
        }
    }

    private void buildGraphOfItems(List<List<Integer>> beforeItems, int n) {
        for (int i = 0; i < beforeItems.size(); i++) {
            int toItem = i;
            for (int fromItem : beforeItems.get(toItem)) {
                itemGraph.computeIfAbsent(fromItem, x -> new ArrayList()).add(toItem);
                itemsIndegree[toItem]++;
            }
        }
    }

    /**
     * Kahn's algorithm
     */
    private List<Integer> topologicalSortUtil(Map<Integer, List<Integer>> graph, int[] indegree, int n) {
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            if (indegree[entry.getKey()] == 0) {
                queue.add(entry.getKey());
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            result.add(node);
            for (int neighbor : graph.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return result.size() == n ? result : new ArrayList<>();
    }

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        groupGraph = new HashMap<>();
        itemGraph = new HashMap<>();

        // create new groups for each element that is -1. So that they can be ordered as well independently.
        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }

        groupsIndegree = new int[m];
        itemsIndegree = new int[n];

        for (int i = 0; i < m; i++) {
            groupGraph.put(i, new ArrayList());
        }

        for (int i = 0; i < n; i++) {
            itemGraph.put(i, new ArrayList());
        }

        // form graph structure across different groups and also calculate indegree.
        buildGraphOfGroups(group, beforeItems, n);

        // Topological ordering of the groups.
        List<Integer> groupsList = topologicalSortUtil(groupGraph, groupsIndegree, m);

        // form graph structure across different items and also calculate indegree.
        buildGraphOfItems(beforeItems, n);

        // Topological ordering of the items.
        List<Integer> itemsList = topologicalSortUtil(itemGraph, itemsIndegree, n);

        // Detect if there are any cycles.
        if (groupsList.size() == 0 || itemsList.size() == 0) return new int[0];

        // This Map holds relative order of items in the same group computed in the loop below.
        Map<Integer, List<Integer>> groupsToItems = new HashMap<>();

        for (Integer item : itemsList) {
            groupsToItems.computeIfAbsent(group[item], x -> new ArrayList()).add(item);
        }

        int[] ans = new int[n];
        int idx = 0;
        for (Integer grp : groupsList) {
            List<Integer> items = groupsToItems.getOrDefault(grp, new ArrayList());
            for (Integer item : items) {
                ans[idx++] = item;
            }
        }

        return ans;
    }

}

