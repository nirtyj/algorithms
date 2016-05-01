package sorting;

public class SelectionSort {

	public static void sort(Integer arr[]) {
		int minIndex;
		for (int i = 0; i < arr.length; i++) {

			minIndex = i;//assign minimum index as current

			for (int j = i + 1; j < arr.length; j++) { // iterate through all the other positions from i+1 to end				
				if (arr[j] < arr[minIndex]) // find minimum position of element
					minIndex = j;
			}

			if (minIndex != i) {// if the minimum position is found then swap with the i th position value
				int temp = arr[minIndex];
				arr[minIndex] = arr[i];
				arr[i] = temp;
			}
		}
	}
}
