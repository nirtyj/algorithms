package careercup.facebook;

import java.util.ArrayList;
import java.util.List;

/**
check if there is a cycle in a directed graph, if there is a cycle, remove all the cycles
 */
public class CycleInDAG {
	class DirectedGraphNode {
		int label;
		List<DirectedGraphNode> neighbors;

		DirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<>();
		}
	}
}
