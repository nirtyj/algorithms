package epi.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphVertex {

	public static enum Color {
		WHITE, GRAY, BLACK
	}

	public Color color;
	public int label;
	public List<GraphVertex> edges;

	public GraphVertex() {
		color = Color.WHITE;
		edges = new ArrayList<>();
	}

	public GraphVertex(int label) {
		color = Color.WHITE;
		this.label = label;
		edges = new ArrayList<>();
	}
}
