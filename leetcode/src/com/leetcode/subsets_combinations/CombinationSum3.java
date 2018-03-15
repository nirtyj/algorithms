package com.leetcode.subsets_combinations;

import java.util.ArrayList;
import java.util.List;

/**
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Example 1:
Input: k = 3, n = 7
Output:
[[1,2,4]]

Example 2:
Input: k = 3, n = 9

Output:
[[1,2,6], [1,3,5], [2,3,4]]
*/
public class CombinationSum3 {

	/**
	 * Leetcode verified
	 * @param k
	 * @param target
	 * @return
	 */
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
