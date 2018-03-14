package careercup.facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * find LCA in directed acyclic graph
 */
public class LCAinDAG {

	class Node {
		int label;
		List<Node> neighbors;

		Node(int x) {
			label = x;
			neighbors = new ArrayList<>();
		}
	}

	public List<Node> findLCAINDAG(Node graph, Node n1, Node n2) {
		return null;
	}
}
