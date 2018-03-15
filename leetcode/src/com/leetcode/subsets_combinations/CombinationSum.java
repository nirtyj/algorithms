package com.leetcode.subsets_combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
Given a set of candidate numbers (C) (without duplicates) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
*/
public class CombinationSum {

	/**
	 * Leetcode verified
	 */
	public static List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, target, 0);
		return list;
	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
		if (remain < 0)
			return;
		else if (remain == 0)
			list.add(new ArrayList<>(tempList));
		else {
			for (int i = start; i < nums.length; i++) {
				tempList.add(nums[i]);
				backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	public static List<List<Integer>> combinationSumMine(List<Integer> candidates, int target) {

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
			if (currentSum + i > target)
				break;
			arrayList.add(candidates.get(i));
			combinationSumHelper(candidates, target, currentSum + candidates.get(i), i, arrayList, result);
			arrayList.remove(arrayList.size() - 1);
		}
	}
}
