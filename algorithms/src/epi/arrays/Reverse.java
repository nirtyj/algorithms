package epi.arrays;

public class Reverse {

	public static void rvereseArray(int arr[]) {
		int i = 0;
		int j = arr.length -1;
		while (i <= j) {
			int temp = arr[j];
			arr[j] = arr[i];
			arr[i] = temp;
			i++;
			j--;
		}
	}
}
