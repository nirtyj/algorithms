package com.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 */
public class CloningGraph {

	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};

	Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

	/**
	 * Leetcode verified
	 * @param node
	 * @return
	 */
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

		if (node == null) {
			return null;
		}
		UndirectedGraphNode nd = map.get(node);
		if (nd == null) {
			nd = new UndirectedGraphNode(node.label);
			map.put(node, nd);
			for (UndirectedGraphNode nei : node.neighbors) {
				nd.neighbors.add(cloneGraph(nei));
			}
		}
		return nd;
	}

	public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
		if (node == null)
			return null;

		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		queue.add(node);
		UndirectedGraphNode clonedNode = new UndirectedGraphNode(node.label);
		map.put(node, clonedNode);
		while (!queue.isEmpty()) {
			UndirectedGraphNode currNode = queue.poll();
			clonedNode = map.get(currNode);
			for (UndirectedGraphNode n : currNode.neighbors) {
				UndirectedGraphNode clonedNeighbor = null;
				if (map.containsKey(n)) {
					clonedNeighbor = map.get(n);
				} else {
					clonedNeighbor = new UndirectedGraphNode(n.label);
					map.put(n, clonedNeighbor);
					queue.add(n);
				}
				clonedNode.neighbors.add(clonedNeighbor);
			}
		}
		return map.get(node);
	}
}
