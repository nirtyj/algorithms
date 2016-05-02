package epi.graph;

import java.util.List;

import epi.graph.GraphVertex.Color;

public class DeadlockDetection {

	public static boolean isDeadlocked(List<GraphVertex> G) {
		for (GraphVertex vertex : G) {
			if (vertex.color == Color.WHITE && hasCycle(vertex))
				return true;
		}
		return false;
	}

	private static boolean hasCycle(GraphVertex vertex) {

		if (vertex.color == Color.GRAY)
			return true;

		vertex.color = Color.GRAY;

		for (GraphVertex subs : vertex.edges) {
			if (subs.color != GraphVertex.Color.BLACK) {
				boolean result = hasCycle(subs);
				if (result == true)
					return true;
			}
		}

		vertex.color = Color.BLACK;
		return false;
	}
}
