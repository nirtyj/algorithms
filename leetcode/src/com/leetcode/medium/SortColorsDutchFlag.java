package com.leetcode.medium;

/**
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
*/
public class SortColorsDutchFlag {
	public void sortColors(int[] A) {
		int second = A.length - 1, zero = 0;
		for (int i = 0; i <= second; i++) {
			while (A[i] == 2 && i < second)
				swap(A, i, second--);
			while (A[i] == 0 && i > zero)
				swap(A, i, zero++);
		}
	}

	private void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
