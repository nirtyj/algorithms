package com.leetcode.subsets_combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
*/
public class CombinationSum2 {

	/**
	 * Leetcode verified
	 * @param nums
	 * @param target
	 * @return
	 */
	public static List<List<Integer>> combinationSum(int[] nums, int target) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, target, 0);
	    return list;
	    
	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
	    if(remain < 0) 
	    	return;
	    else if(remain == 0) 
	    	list.add(new ArrayList<>(tempList));
	    else{
	        for(int i = start; i < nums.length; i++){
	            if(i > start && nums[i] == nums[i-1]) 
	            	continue; // skip duplicates
	            tempList.add(nums[i]);
	            backtrack(list, tempList, nums, remain - nums[i], i + 1);
	            tempList.remove(tempList.size() - 1); 
	        }
	    }
	} 
	
	
	public static List<List<Integer>> combinationSumMine(List<Integer> candidates, int target) {

		List<List<Integer>> result = new ArrayList<>();
		Collections.sort(candidates);

		combinationSumHelper(candidates, target, 0, 0, new ArrayList<Integer>(), result);
		HashSet<? extends List<Integer>> set = new HashSet<>(result);
		result.clear();
		result.addAll(set);
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
			combinationSumHelper(candidates, target, currentSum + candidates.get(i), i + 1, arrayList, result);
			arrayList.remove(arrayList.size() - 1);
		}
	}
}
