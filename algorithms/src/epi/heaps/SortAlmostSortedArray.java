package epi.heaps;

import java.util.List;
import java.util.PriorityQueue;

public class SortAlmostSortedArray {

	public static void sortAlmost(List<Integer> array, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);

		for (int i = 0; i < k; i++)
			minHeap.add(array.get(i));

		int i = 0;
		int j = k;
		while (minHeap.peek() != null) {
			array.set(i, minHeap.poll());
			i++;
			if (j < array.size()) {
				minHeap.add(array.get(j));
				j++;
			}
		}
	}

}
