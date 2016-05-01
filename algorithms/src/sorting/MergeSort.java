package sorting;

public class MergeSort {

	public static void sort(Integer arr[]) {
		mergeSort_srt(arr, 0, arr.length-1);
	}

	private static void mergeSort_srt(Integer array[], int lo, int n) {
		int low = lo;
		int high = n;
		if (low >= high) {
			return;
		}

		int middle = low + (high - low) / 2;
		mergeSort_srt(array, low, middle);
		mergeSort_srt(array, middle + 1, high);
		
		//merge them both
		
		int end_low = middle;
		int start_high = middle + 1;
		
		
		while ((lo <= end_low) && (start_high <= high)) {
			if (array[low] < array[start_high]) {
				low++;
			} else {
				int Temp = array[start_high];
				for (int k = start_high - 1; k >= low; k--) { //shift to right and insert
					array[k + 1] = array[k];
				}
				array[low] = Temp; //insert
				low++;
				end_low++;
				start_high++;
			}
		}
	}

}
