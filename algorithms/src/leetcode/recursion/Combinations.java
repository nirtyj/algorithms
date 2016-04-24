package leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		combinationSumHelper(n, k, 0, 1, new ArrayList<Integer>(), result);
		return result;
	}
	
	private static void combinationSumHelper(int targetEnd, int targetSize, int currentSum, int currIndex,
			ArrayList<Integer> arrayList, List<List<Integer>> result) {

		if (targetSize == arrayList.size()) {
			result.add(new ArrayList<Integer>(arrayList));
			return;
		} else if (arrayList.size() > targetSize) {
			return;
		}

		for (int i = currIndex; i <= targetEnd; i++) {
			if(arrayList.size()>targetSize) 
				break;
		        
			arrayList.add(i);
			combinationSumHelper(targetEnd, targetSize, currentSum + i, i + 1, arrayList, result);
			arrayList.remove(arrayList.size() - 1);
		}
	}
}
