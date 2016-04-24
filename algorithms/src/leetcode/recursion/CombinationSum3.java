package leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

	public static List<List<Integer>> combinationSum3(int k, int target) {
		List<List<Integer>> result = new ArrayList<>();
		combinationSumHelper(target, k, 0, 1, new ArrayList<Integer>(), result);
		return result;

	}
	
	private static void combinationSumHelper(int target, int targetSize, int currentSum, int currIndex,
			ArrayList<Integer> arrayList, List<List<Integer>> result) {

		if (currentSum == target && targetSize == arrayList.size()) {
			result.add(new ArrayList<Integer>(arrayList));
			return;
		} else if (currentSum > target || arrayList.size() > targetSize) {
			return;
		}

		for (int i = currIndex; i <= 9; i++) {
			if(currentSum + i > target) 
				break;
		    
			if(arrayList.size()>targetSize) 
				break;
		        
			arrayList.add(i);
			combinationSumHelper(target, targetSize, currentSum + i, i + 1, arrayList, result);
			arrayList.remove(arrayList.size() - 1);
		}
	}
}
