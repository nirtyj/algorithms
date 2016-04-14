package epi.searching;

import java.util.List;

public class FirstOccuranceInSortedArray {

	public static int findFirstOccuranceofK(List<Integer> list, int key) {
		int left = 0;
		int right = list.size() - 1;
		int result = -1;

		while (left <= right) {
			int middle = left + (right - left) / 2;
			if (key == list.get(middle)) {
				result = middle;
				right = middle - 1;
			} else if (key < list.get(middle)) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		return result;
	}
}
