package com.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p>
 * Your algorithm should run in O(n) complexity.
 * <p>
 * Example:
 * <p>
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class LengthOfLongestConsecutiveSequence {

    /**
     * Leetcode verifiedd
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }
        int longestStreak = 0;
        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    /**
     * Leetcode verified
     *
     * @param nums
     * @return
     */
    public int longestConsecutiveUnionFind(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        else if (nums.length == 1)
            return 1;
        Map<Integer, Integer> dsu = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            dsu.put(nums[i], nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MIN_VALUE && dsu.containsKey(nums[i] - 1)) {
                dsu.put(Math.max(nums[i], nums[i] - 1), Math.min(nums[i], nums[i] - 1));
            }
            if (nums[i] != Integer.MAX_VALUE && dsu.containsKey(nums[i] + 1)) {
                dsu.put(Math.max(nums[i], nums[i] + 1), Math.min(nums[i], nums[i] + 1));
            }
        }
        Map<Integer, Integer> length = new HashMap<Integer, Integer>();
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            Integer key = nums[i];
            int le = getLength(length, dsu, key);
            maxLength = Math.max(maxLength, le);
        }
        return maxLength;
    }

    int getLength(Map<Integer, Integer> length, Map<Integer, Integer> dsu, int key) {
        if (length.containsKey(key))
            return length.get(key);
        if (dsu.get(key) == key) {
            length.put(key, 1);
            return 1;
        }
        int result = getLength(length, dsu, dsu.get(key));
        result++;
        length.put(key, result);
        return result;
    }
}
