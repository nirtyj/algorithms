package epi.searching;

import java.util.List;

public class DuplicateAndMissing {

	public static int findMissingElement(List<Integer> arr) {
		int x1 = arr.get(0);
		for (int i = 1; i < arr.size(); i++) {
			x1 = x1 ^ arr.get(i);
		}

		int x2 = 1;
		for (int i = 2; i <= arr.size()+1; i++) {
			x2 = x2 ^ i;
		}

		return x1 ^ x2;

	}
}
