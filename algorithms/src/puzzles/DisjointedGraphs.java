package puzzles;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Get disjointed graph clusters from a list of graph nodes
 * @author njaganat
 *
 */
public class DisjointedGraphs {

	class Node {
		String data;
		int color;
		Node next;
	}

	Collection<Collection<Node>> getDisjointedGraphs(List<Node> nodes) {

		Map<Integer, Integer> subGroupToColorMap = new HashMap<Integer, Integer>();

		int subgroupCount = 1;
		int colorCount = 1;
		for (Node node : nodes) {
			Node currNode = node;
			subGroupToColorMap.put(subgroupCount, colorCount);
			while (currNode != null) {
				// unvisited node
				if (currNode.color == 0) {
					currNode.color = subgroupCount;
					currNode = currNode.next;
				}
				// loop back
				else if (currNode.color == subgroupCount) {
					break;
				}
				// merging into previously seen group
				else {
					int colorAssociated = subGroupToColorMap.get(currNode.color);
					subGroupToColorMap.put(subgroupCount, colorAssociated);
					break;
				}
			}
			subgroupCount++;
			colorCount++;
		}

		for (Node node : nodes) {
			node.color = subGroupToColorMap.get(node.color);
		}

		Map<Integer, Collection<Node>> groups = new HashMap<>();
		for (Node node : nodes) {
			if (groups.containsKey(node.color)) {
				Collection<Node> group = groups.get(node.color);
				group.add(node);
			} else {
				LinkedList<Node> newGroup = new LinkedList<>();
				newGroup.add(node);
				groups.put(node.color, newGroup);
			}
		}

		return groups.values();
	}

}
