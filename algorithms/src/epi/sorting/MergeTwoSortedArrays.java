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

	/**
	 * Leetcode verified
	 * @param arr1
	 * @param m
	 * @param arr2
	 * @param n
	 */
	public void mergeSortedArrays2(List<Integer> arr1, int m, List<Integer> arr2, int n) {

		int i = m - 1;
		int j = n - 1;
		int writeIndex = m + n - 1;

		while (i >= 0 && j >= 0) {
			if (arr1.get(i) >= arr2.get(j)) {
				arr1.set(writeIndex, arr1.get(i));
				writeIndex--;
				i--;
			} else {
				arr1.set(writeIndex, arr2.get(j));
				writeIndex--;
				j--;
			}
		}

		while (j >= 0) {
			arr1.set(writeIndex, arr2.get(j));
			writeIndex--;
			j--;
		}
	}

}
