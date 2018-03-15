package com.leetcode.subsets_combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
public class Subsets {

	/**
	 * Leetcode verified
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, 0);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
		list.add(new ArrayList<>(tempList));
		for (int i = start; i < nums.length; i++) {
			tempList.add(nums[i]);
			backtrack(list, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}
	
	/**
	 * Leetcode verified
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsetsItertive(int[] nums) {
		List<List<Integer>> ps = new ArrayList<>();
		ps.add(new ArrayList<Integer>()); // add the empty set

		// for every item in the original list

		for (int i = 0; i < nums.length; i++) {
			Integer item = nums[i];
			List<List<Integer>> newPs = new ArrayList<List<Integer>>();

			for (List<Integer> subset : ps) {
				// copy all of the current powerset's subsets
				newPs.add(subset);

				// plus the subsets appended with the current item
				List<Integer> newSubset = new ArrayList<Integer>(subset);
				newSubset.add(item);
				newPs.add(newSubset);
			}

			// powerset is now powerset of list.subList(0, list.indexOf(item)+1)
			ps = newPs;
		}
		return ps;
	}
}
