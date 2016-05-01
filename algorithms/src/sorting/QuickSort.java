package sorting;

import java.util.Arrays;

public class QuickSort {

	public static void sort(Integer[] anArray) {
		quickSort(anArray, 0, anArray.length - 1);
	}

	public static void quickSort(Integer[] arr, int left, int right) {
		if (arr == null || arr.length == 0)
			return;

		if (left >= right)
			return;

		System.out.println("-------Starting----------");
		System.out.println(Arrays.toString(arr));
		// pick the pivot
		int pivot = arr[left + (right - left) / 2];
		System.out.println("pivot is " + pivot);
		// make left < pivot and right > pivot
		int i = left, j = right;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}

			while (arr[j] > pivot) {
				j--;
			}

			if (i <= j) {
				System.out.println("swapping i:" + i + " => " + arr[i] + " ; j: " + j + " => " + arr[j]);
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
				System.out.println(Arrays.toString(arr));
			}

		}
		System.out.println("-----------------");

		// recursively sort two sub parts
		if (left < j)
			quickSort(arr, left, j);

		if (right > i)
			quickSort(arr, i, right);
	}
}