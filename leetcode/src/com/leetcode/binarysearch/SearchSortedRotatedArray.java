package com.leetcode.binarysearch;

import java.util.List;

/**
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

*/
public class SearchSortedRotatedArray {

	/**
	 * Leetcode accepted
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
