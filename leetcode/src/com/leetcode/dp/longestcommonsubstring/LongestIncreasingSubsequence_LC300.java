package com.leetcode.dp.longestcommonsubstring;

import java.util.Arrays;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p>
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 * <p>
 * Your algorithm should run in O(n2) complexity.
 * <p>
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence_LC300 {

    /**
     * Leetcode verified - O(n^2)
     *
     * @param nums
     * @return
     */
    public static int lengthOfLISDp(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        else if (nums.length == 1)
            return 1;

        int result = 1;
        int[] maxlength = new int[nums.length];
        Arrays.fill(maxlength, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxlength[i] = Math.max(maxlength[i], (maxlength[j] + 1));
                    result = Math.max(maxlength[i], result);
                }

            }
        }
        return result;
    }

    /**
     * http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
     * http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
     */
    public int lengthOfLISRecusion(int[] nums) {
        return findLISLengthRecursive(nums, 0, -1);
    }

    private int findLISLengthRecursive(int[] nums, int currentIndex, int previousIndex) {
        if(currentIndex == nums.length)
            return 0;

        // include nums[currentIndex] if it is larger than the last included number
        int c1 = 0;
        if(previousIndex == -1 || nums[currentIndex] > nums[previousIndex])
            c1 = 1 + findLISLengthRecursive(nums, currentIndex+1, currentIndex);

        // excluding the number at currentIndex
        int c2 = findLISLengthRecursive(nums, currentIndex+1, previousIndex);

        return Math.max(c1, c2);
    }

}
