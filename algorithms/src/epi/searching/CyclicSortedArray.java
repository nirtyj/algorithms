package epi.searching;

import java.util.List;

public class CyclicSortedArray {

	public static int findPivot(List<Integer> list) {
		int left = 0;
		int right = list.size() - 1;

		while (left < right) {
			int middle = left + (right - left) / 2;
			if (list.get(middle) > list.get(right)) {
				left = middle + 1;
			} else {
				right = middle;
			}
		}
		return left;
	}

	/**
	 * http://articles.leetcode.com/searching-element-in-rotated-array/
	 * @param arr
	 * @param key
	 * @return
	 */
	public static int searchElement(List<Integer> list, int key) {
		int left = 0;
		int right = list.size() - 1;

		while (left <= right) {
			int middle = left + (right - left) / 2;
			if (key == list.get(middle))
				return middle;

			if (list.get(left) <= list.get(middle)) {
				if (list.get(left) <= key && key < list.get(middle))
					right = middle - 1;
				else
					left = middle + 1;

			} else {
				if (list.get(middle) < key && key <= list.get(right))
					left = middle + 1;
				else
					right = middle - 1;
			}
		}
		return -1;
	}
}
