package epi.searching;

import java.util.List;

public class SearchEntryEqualToIndex {

	public static int searchEntryEqualtoIndex(List<Integer> list) {
		int left = 0;
		int right = list.size() - 1;
		int result = -1;

		while (left <= right) {
			int middle = left + (right - left) / 2;
			if (list.get(middle) == middle) {
				return middle;
			} else if (list.get(middle) > middle) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		return result;
	}
}
