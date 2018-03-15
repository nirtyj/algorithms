package com.leetcode.permutations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/
public class PermutationsII {

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		if (nums.length == 0)
			return list;
		List<Integer> intList = new ArrayList<Integer>();
		for (int index = 0; index < nums.length; index++) {
			intList.add(nums[index]);
		}
		permuteAll(intList, list, new ArrayList<Integer>());
		return list;
	}

	private void permuteAll(List<Integer> init, List<List<Integer>> list, List<Integer> curr) {
		if (init.size() == 0) {
			list.add(new ArrayList<>(curr));
			return;
		}
		Set<Integer> appeared = new HashSet<>();
		for (int i = 0; i < init.size(); i++) {
			if (appeared.add(init.get(i))) {
				// add it to the current and remove from init
				Integer val = init.get(i);
				curr.add(val);
				init.remove(i);
				permuteAll(init, list, curr);

				// remove the last added current & put it back to the init at the same position
				curr.remove(curr.size() - 1);
				init.add(i, val);
			}
		}
	}
}
