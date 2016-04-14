package epi.searching;

import java.util.List;

public class BinarySearch {

	public static int search(List<Integer> list, int key) {
		int left = 0;
		int right = list.size() - 1;

		while (left <= right) {
			int middle = left + (right - left) / 2;
			if (key == list.get(middle)) {
				return middle;
			} else if (key < list.get(middle)) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		return -1;
	}

	public static int searchRecurse(List<Integer> list, int key, int left, int right) {
		if (left <= right) {
			int middle = left + (right - left) / 2;
			if (key == list.get(middle)) {
				return middle;
			} else if (key < list.get(middle)) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
			return searchRecurse(list, key, left, right);
		}
		return -1;
	}
}
