package com.leetcode.binarysearch;

import java.util.ArrayList;

/**
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Write a function to determine if a given target is in the array.

The array may contain duplicates.
*/
public class SearchSortedRotatedArrayII {

	/**
	 * Leetcode verified
	 * 
	 * @param nums
	 * @param key
	 * @return
	 */
	public boolean search(int[] nums, int key) {
		if (nums == null || nums.length == 0)
			return false;

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int num : nums) {
			list.add(num);
		}
		int left = 0;
		int right = list.size() - 1;

		while (left <= right) {
			int middle = left + (right - left) / 2;
			if (key == list.get(middle))
				return true;

			if (list.get(left) < list.get(middle)) {
				if (list.get(left) <= key && key < list.get(middle))
					right = middle - 1;
				else
					left = middle + 1;

			} else if (list.get(left) > list.get(middle)) {
				if (list.get(middle) < key && key <= list.get(right))
					left = middle + 1;
				else
					right = middle - 1;
			} else {
				left++;
			}
		}
		return false;
	}
}
