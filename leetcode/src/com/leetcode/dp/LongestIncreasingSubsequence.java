package com.leetcode.dp;

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
public class LongestIncreasingSubsequence {

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
     * https://leetcode.com/problems/longest-increasing-subsequence/solution/ - only gives you the length. improper
     * n log n
     * input: [0, 8, 4, 12, 2]
     * dp: [0]
     * <p>
     * dp: [0, 8]
     * <p>
     * dp: [0, 4]
     * <p>
     * dp: [0, 4, 12]
     * <p>
     * dp: [0 , 2, 12] which is not the longest increasing subsequence, but length of dpdp array results in length of Longest Increasing Subsequence.
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                // insert at the end
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }


    /**
     * http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
     * http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
     */
    public static int lengthOfLISRecusion(int[] nums) {
        return lisRecursionHelper(nums, 0, 0);
    }

    public static int lisRecursionHelper(int[] nums, int currIndex, int maxLength) {
        if (currIndex == nums.length - 1) {
            return 1;
        }

        int maxLengthLocal = maxLength;
        for (int i = currIndex + 1; i < nums.length; i++) {
            if (nums[i] > nums[currIndex])
                maxLengthLocal = Math.max(maxLengthLocal, 1 + lisRecursionHelper(nums, i, maxLength));
            else
                maxLengthLocal = Math.max(maxLengthLocal, lisRecursionHelper(nums, i, maxLength));
        }

        return maxLengthLocal;
    }

}
