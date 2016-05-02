package epi.graph;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DeadlockDetectionTest {

	private boolean hasCycleExclusion(GraphVertex cur, GraphVertex prev) {
		if (cur.color == GraphVertex.Color.BLACK) {
			return true;
		}
		cur.color = GraphVertex.Color.BLACK;
		for (GraphVertex next : cur.edges) {
			if (next != prev) {
				if (hasCycleExclusion(next, cur)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkAnswer(List<GraphVertex> G) {
		// marks all vertices as white.
		for (GraphVertex n : G) {
			n.color = GraphVertex.Color.WHITE;
		}

		for (GraphVertex g : G) {
			if (hasCycleExclusion(g, null)) {
				return true;
			}
			// Reset color to white.
			for (GraphVertex n : G) {
				n.color = GraphVertex.Color.WHITE;
			}
		}
		return false;
	}

	@Test
	public void test() {
		int n = 3;
		List<GraphVertex> G = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			G.add(new GraphVertex());
		}
		G.get(0).edges.add(G.get(1));
		G.get(1).edges.add(G.get(2));
		G.get(2).edges.add(G.get(0));
		boolean result = DeadlockDetection.isDeadlocked(G);
		System.out.println(result);
		assertTrue(checkAnswer(G) == result);
		assertTrue(result);
	}

	@Test
	public void testDirectedStarTree() {
		int n = 4;
		List<GraphVertex> G = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			G.add(new GraphVertex());
		}
		G.get(0).edges.add(G.get(1));
		G.get(0).edges.add(G.get(2));
		G.get(0).edges.add(G.get(3));
		boolean result = DeadlockDetection.isDeadlocked(G);
		System.out.println(result);
		assertTrue(checkAnswer(G) == result);
		assertTrue(!result);
	}

	@Test
	public void test2() {
		int n = 4;
		List<GraphVertex> G = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			G.add(new GraphVertex());
		}
		G.get(0).edges.add(G.get(1));
		G.get(1).edges.add(G.get(2));
		G.get(2).edges.add(G.get(3));
		boolean result = DeadlockDetection.isDeadlocked(G);
		System.out.println(result);
		assertTrue(checkAnswer(G) == result);
		assertTrue(!result);
		G.get(3).edges.add(G.get(1));
		result = DeadlockDetection.isDeadlocked(G);
		assertTrue(result);
	}

	@Test
	public void testDirectedBinaryTree() {
		int n = 7;
		List<GraphVertex> G = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			G.add(new GraphVertex());
		}
		G.get(0).edges.add(G.get(1));
		G.get(0).edges.add(G.get(2));
		G.get(1).edges.add(G.get(3));
		G.get(1).edges.add(G.get(4));
		G.get(2).edges.add(G.get(5));
		G.get(2).edges.add(G.get(6));
		boolean result = DeadlockDetection.isDeadlocked(G);
		System.out.println(result);
		assertTrue(checkAnswer(G) == result);
		assertTrue(!result);
		G.get(4).edges.add(G.get(6));
		G.get(6).edges.add(G.get(1));
		result = DeadlockDetection.isDeadlocked(G);
		assertTrue(result);
	}

	@Test
	public void testDirectedTwoSeparateCycles() {
		int n = 6;
		List<GraphVertex> G = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			G.add(new GraphVertex());
		}
		G.get(0).edges.add(G.get(1));
		G.get(1).edges.add(G.get(2));
		G.get(2).edges.add(G.get(0));
		G.get(0).edges.add(G.get(2));
		G.get(3).edges.add(G.get(4));
		G.get(4).edges.add(G.get(5));
		G.get(5).edges.add(G.get(3));
		boolean result = DeadlockDetection.isDeadlocked(G);
		assertTrue(result);
	}
}
