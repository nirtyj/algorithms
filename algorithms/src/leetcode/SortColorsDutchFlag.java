package leetcode;

/**
 * Leetcode verified
 * @author njaganathan
 *
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
