package epi.sorting;

import java.util.Collections;
import java.util.List;

public class MergeTwoSortedArrays {

	public void mergeSortedArrays(List<Integer> arr1, int m, List<Integer> arr2, int n) {

		List<Integer> largeArr;
		List<Integer> smallArr;
		if (m > n) {
			largeArr = arr1;
			smallArr = arr2;
		} else {
			largeArr = arr2;
			smallArr = arr1;
		}

		largeArr.addAll(smallArr);
		Collections.sort(largeArr);
	}

}
