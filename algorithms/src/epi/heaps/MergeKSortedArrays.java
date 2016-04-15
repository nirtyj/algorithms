package epi.heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

	public static class ArrayNode {
		int value;
		int arrayId;
		int nextIndex;

		public ArrayNode(int value, int arrayId, int nextIndex) {
			this.value = value;
			this.arrayId = arrayId;
			this.nextIndex = nextIndex;
		}
	}

	public static List<Integer> mergeKArrays(List<List<Integer>> arrOfArrays) {
		List<Integer> result = new ArrayList<Integer>();
		PriorityQueue<ArrayNode> minHeap = new PriorityQueue<ArrayNode>(arrOfArrays.size(),
				new Comparator<ArrayNode>() {

					@Override
					public int compare(ArrayNode o1, ArrayNode o2) {
						return Integer.compare(o1.value, o2.value);
					}
				});

		for (int i = 0; i < arrOfArrays.size(); i++) {
			minHeap.add(new ArrayNode(arrOfArrays.get(i).get(0), i, 1));
		}

		while (minHeap.peek() != null) {
			ArrayNode node = minHeap.poll();
			result.add(node.value);
			List<Integer> array = arrOfArrays.get(node.arrayId);
			if (node.nextIndex < array.size()) {
				minHeap.add(new ArrayNode(array.get(node.nextIndex), node.arrayId, node.nextIndex + 1));
			}
		}
		return result;
	}
}
