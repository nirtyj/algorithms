package epi.graph;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

import org.junit.Test;

public class CloningGraphTest {

	private static List<Integer> copyLabels(List<GraphVertex> edges) {
		List<Integer> labels = new ArrayList<>();
		for (GraphVertex e : edges) {
			labels.add(e.label);
		}
		return labels;
	}

	private static void checkGraph(GraphVertex node, List<GraphVertex> g) {
		Set<GraphVertex> vertexSet = new HashSet<>();
		Queue<GraphVertex> q = new LinkedList<>();
		q.add(node);
		vertexSet.add(node);
		while (!q.isEmpty()) {
			GraphVertex vertex = q.remove();
			assertTrue (vertex.label < g.size());
			List<Integer> label1 = copyLabels(vertex.edges), label2 = copyLabels(g.get(vertex.label).edges);
			Collections.sort(label1);
			Collections.sort(label2);
			assertTrue (label1.size() == label2.size());
			assertTrue (Arrays.equals(label1.toArray(), label2.toArray()));
			for (GraphVertex e : vertex.edges) {
				if (!vertexSet.contains(e)) {
					vertexSet.add(e);
					q.add(e);
				}
			}
		}
	}

	@Test
	public void test() {
		Random r = new Random();
		for (int times = 0; times < 2; ++times) {
			List<GraphVertex> G = new ArrayList<>();
			int n = r.nextInt(100) + 2;

			for (int i = 0; i < n; ++i) {
				G.add(new GraphVertex(i));
			}
			int m = r.nextInt(n * (n - 1) / 2) + 1;
			boolean[][] doesEdgeExist = new boolean[n][n];
			// Make the graph become connected.
			for (int i = 1; i < n; ++i) {
				G.get(i - 1).edges.add(G.get(i));
				G.get(i).edges.add(G.get(i - 1));
				doesEdgeExist[i - 1][i] = doesEdgeExist[i][i - 1] = true;
			}

			// Generate some edges randomly.
			m -= (n - 1);
			while (m-- > 0) {
				int a, b;
				do {
					a = r.nextInt(n);
					b = r.nextInt(n);
				} while (a == b || doesEdgeExist[a][b]);
				doesEdgeExist[a][b] = doesEdgeExist[b][a] = true;
				G.get(a).edges.add(G.get(b));
				G.get(b).edges.add(G.get(a));
			}
			GraphVertex res = CloningGraph.cloneGraph(G.get(0));
			assertFalse(res == G.get(0));
			checkGraph(res, G);
		}
	}

}
