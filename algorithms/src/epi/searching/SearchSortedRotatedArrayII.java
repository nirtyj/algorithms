package epi.searching;

import java.util.ArrayList;

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
