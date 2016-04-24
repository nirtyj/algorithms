package epi.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetSizeK {

	public static List<List<Integer>> combinations(int n, int size) {
		List<List<Integer>> result = new ArrayList<>();
		directedCombinations(n, size, 1, new ArrayList<Integer>(), result);
		return result;
	}

	private static void directedCombinations(int n, int size, int nextIndex, List<Integer> partialCombination,
			List<List<Integer>> result) {
		if (partialCombination.size() == size) {
			result.add(new ArrayList<>(partialCombination));
			return;
		}

		for (int i = nextIndex; i <= n; i++) {
			partialCombination.add(i);
			directedCombinations(n, size, i + 1, partialCombination, result);
			partialCombination.remove(partialCombination.size() - 1);
		}

	}

}
