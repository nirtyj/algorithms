package epi.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloningGraph {

	public static GraphVertex cloneGraph(GraphVertex g) {

		if (g == null) {
			return null;
		}

		Queue<GraphVertex> queue = new LinkedList<GraphVertex>();
		queue.add(g);
		Map<GraphVertex, GraphVertex> mapOfOldToNew = new HashMap<GraphVertex, GraphVertex>();
		mapOfOldToNew.put(g, new GraphVertex(g.label));
		
		while (!queue.isEmpty()) {
			GraphVertex curr = queue.poll();
			GraphVertex clone = mapOfOldToNew.get(curr);

			for (GraphVertex vertex : curr.edges) {
				if (!mapOfOldToNew.containsKey(vertex)) {
					GraphVertex clonedEdge = new GraphVertex(vertex.label);
					queue.add(vertex);
					mapOfOldToNew.put(vertex, clonedEdge);
				}

				clone.edges.add(mapOfOldToNew.get(vertex));
			}
		}

		return mapOfOldToNew.get(g);
	}
}