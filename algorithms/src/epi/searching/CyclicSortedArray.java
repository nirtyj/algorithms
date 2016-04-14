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
	public static int searchElement(List<Integer> arr, int key) {
		return 0;
	}
}
