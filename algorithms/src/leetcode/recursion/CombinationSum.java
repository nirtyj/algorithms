package leetcode.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

	public static List<List<Integer>> combinationSum(List<Integer> candidates, int target) {

		List<List<Integer>> result = new ArrayList<>();
		Collections.sort(candidates);

		combinationSumHelper(candidates, target, 0, 0, new ArrayList<Integer>(), result);
		return result;
	}

	private static void combinationSumHelper(List<Integer> candidates, int target, int currentSum, int currIndex,
			ArrayList<Integer> arrayList, List<List<Integer>> result) {

		if (currentSum == target) {
			result.add(new ArrayList<Integer>(arrayList));
			return;
		} else if (currentSum > target) {
			return;
		}

		for (int i = currIndex; i < candidates.size(); i++) {
			if(currentSum + i > target) 
				break;
			arrayList.add(candidates.get(i));
			combinationSumHelper(candidates, target, currentSum + candidates.get(i), i, arrayList, result);
			arrayList.remove(arrayList.size() - 1);
		}
	}
}
