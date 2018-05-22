package com.leetcode.graph.unionfind;

/**
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

Example 1:
     0          3
     |          |
     1 --- 2    4
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:
     0           4
     |           |
     1 --- 2 --- 3
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

Note:
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
*/
public class NumberOfConnectedComponentsInUndirectedGraph {

	/**
	 * Leetcode verified
	 * @param n
	 * @param edges
	 * @return
	 */
	public int countComponents(int n, int[][] edges) {
		int[] dsu = new int[n];
		for (int i = 0; i < n; i++)
			dsu[i] = i;

		for (int i = 0; i < edges.length; i++) {
			// find set
			int x = find(edges[i][0], dsu);
			int y = find(edges[i][1], dsu);
			if (x == y)
				continue;
			// union
			dsu[x] = y;
		}
		int result = 0;
		for (int i = 0; i < n; i++) {
			if (dsu[i] == i)
				result++;
		}
		return result;
	}

	private int find(int x, int[] dsu) {
		if (dsu[x] == x)
			return x;
		else
			return find(dsu[x], dsu);
	}
}
