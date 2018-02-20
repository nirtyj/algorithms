package leetcode.subsets_combinations;

import java.util.ArrayList;
import java.util.List;

/**
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [1,2],
  [1,3],
  [1,4],
  [2,3],
  [2,4],
  [3,4],
]
*/
public class Combinations {

	/**
	 * Leetcode verified
	 * combinations upto n numbers; size of k
	 * @param n
	 * @param k
	 * @return
	 */
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		// starts with 1
		combinationSumHelper(n, k,  1, new ArrayList<Integer>(), result);
		return result;
	}
	
	private static void combinationSumHelper(int targetEnd, int targetSize, int currIndex,
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
			combinationSumHelper(targetEnd, targetSize, i + 1, arrayList, result);
			arrayList.remove(arrayList.size() - 1);
		}
	}
}
