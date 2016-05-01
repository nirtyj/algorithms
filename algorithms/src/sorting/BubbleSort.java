package sorting;

public class BubbleSort {

	public static void sort(Integer arr[]) {

		int lastIndexSorted = arr.length - 1;
		boolean swapped = false;
		do {
			swapped = false;
			for (int i = 0; i < lastIndexSorted; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					swapped = true;
				}
			}
			lastIndexSorted = lastIndexSorted - 1;
		} while (swapped);

	}
	
	public static void sortSlow(Integer arr[]) {
		for (int i = 0; i < arr.length; i++)
			for (int j = i; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
	}
}
