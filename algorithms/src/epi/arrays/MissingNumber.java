package epi.arrays;

public class MissingNumber {

	/**
	 * http://www.geeksforgeeks.org/find-the-missing-number/
	 */
	public static int getMissingNo(int a[], int n) {
		int sum = 0;
		for (int i = 0; i < a.length; i++)
			sum = sum + a[i];

		int totalSum = n * (n + 1) / 2;
		return totalSum - sum;
	}

	public static int getMissingNoXor(int a[], int n) {

		int totalXor = 0;
		for (int i = 1; i <= n; i++)
			totalXor = totalXor ^ i;

		int givenXor = 0;
		for (int i = 0; i < a.length; i++)
			givenXor = givenXor ^ a[i];
		return totalXor ^ givenXor;
	}

}
