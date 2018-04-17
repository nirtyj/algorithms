package com.leetcode.easy;

/**
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 
The number of elements initialized in nums1 and nums2 are m and n respectively.
*/
public class MergeSortedArray {
	/**
	 * Leetcode verified
	 * @param arr1
	 * @param m
	 * @param arr2
	 * @param n
	 */
	public void merge(int[] arr1, int m, int[] arr2, int n) {
		int i = m - 1;
		int j = n - 1;
		int writeIndex = m + n - 1;

		while (i >= 0 && j >= 0) {
			if (arr1[i] >= arr2[j])
				arr1[writeIndex--] = arr1[i--];
			else
				arr1[writeIndex--] = arr2[j--];
		}

		while (j >= 0) {
			arr1[writeIndex--] = arr2[j--];
		}
	}
}
