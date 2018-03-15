package com.leetcode.medium;

import java.util.Arrays;

/**
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
*/
public class GraphValidTree {

	public boolean validTree(int n, int[][] edges) {
		// initialize n isolated islands
		int[] nums = new int[n];
		Arrays.fill(nums, -1);

		// perform union find
		for (int i = 0; i < edges.length; i++) {
			// for each node, find the ultimate parent
			int x = find(nums, edges[i][0]);
			
			// for each node, find the ultimate parent
			int y = find(nums, edges[i][1]);
	
			// if two vertices happen to be in the same set
			// then there's a cycle
			// or if both have the same ultimate parents, they are already connected.
			if (x == y)
				return false;

			// union. i.e merge two sets
			nums[x] = y;
		}

		return edges.length == n - 1;
	}

	/**
	 * find untill the parent is -1
	 * @param nums
	 * @param i
	 * @return
	 */
	int find(int nums[], int i) {
		if (nums[i] == -1)
			return i;
		return find(nums, nums[i]);
	}
}
