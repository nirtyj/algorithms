package com.leetcode.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * For example,
 * [1,1,2] have the following unique permutations:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class PermutationsII {

    /**
     * Leetcode verified
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUniqueMine(int[] nums) {
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

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                    continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
