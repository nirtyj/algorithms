package careercup.facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * find LCA in directed acyclic graph - https://www.hackerrank.com/topics/lowest-common-ancestor
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
