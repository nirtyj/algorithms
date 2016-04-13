package epi.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntersectTwoSortedArrays {

	// O(m * log n)
	public List<Integer> intersectTwoSortedArrays1(List<Integer> arr1, List<Integer> arr2) {
		List<Integer> result = new ArrayList<Integer>();
		for (Integer key : arr1) {
			int index = Collections.binarySearch(arr2, key);
			if (index >= 0) {
				result.add(key);
			}
		}
		return result;
	}

	// O(m + n)
	public List<Integer> intersectTwoSortedArrays2(List<Integer> arr1, List<Integer> arr2) {
		List<Integer> result = new ArrayList<Integer>();
		int i = 0;
		int j = 0;
		while (i < arr1.size() && j < arr2.size()) {
			if (arr1.get(i).equals(arr2.get(j))) {
				result.add(arr1.get(i));
				i++;
				j++;
				continue;
			}

			if (arr1.get(i) > arr2.get(j))
				j++;

			if (arr2.get(j) > arr1.get(i))
				i++;
		}
		return result;
	}

}