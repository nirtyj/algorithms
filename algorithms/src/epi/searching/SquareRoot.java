package epi.searching;

public class SquareRoot {

	/**
	 * leetcode verified
	 * 
	 * @param input
	 * @return
	 */
	public static int findSquareRoot(int input) {
		int left = 0;
		int right = input;
		while (left <= right) {
			int middle = left + (right - left) / 2;
			double squared = (double) middle * middle;
			if (squared == input)
				return middle;
			else if (squared > input)
				right = middle - 1;
			else
				left = middle + 1;
		} 
		// return the actual number itself
		return left - 1;
	}

	public static double findSquareRoot(double k) {
		return 0.0;
	}
}
