package com.leetcode.dp;

import java.util.Arrays;

/**
 * Given an unsorted array of integers, find the number of longest increasing subsequence.
 * <p>
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 2
 * Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 5
 * Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
 * Note: Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit signed int.
 */
public class NumberOfLongestIncreasingSubsequence {

    /**
     * Leetcode verified
     *
     * @param nums
     * @return
     */
    public static int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        else if (nums.length == 1)
            return 1;

        int resultMaxLength = 1;
        int[] maxlength = new int[nums.length];
        int[] cnt = new int[nums.length];
        Arrays.fill(maxlength, 1);
        Arrays.fill(cnt, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // if its equal there are other paths available
                    if (maxlength[i] == 1 + maxlength[j]) {
                        cnt[i] = cnt[i] + cnt[j];
                        // else its just from previous number
                    } else if (maxlength[i] < maxlength[j] + 1) {
                        cnt[i] = cnt[j];
                    }
                    maxlength[i] = Math.max(maxlength[i], (maxlength[j] + 1));
                    resultMaxLength = Math.max(maxlength[i], resultMaxLength);
                }

            }
        }

        int result = 0;
        for (int i = 0; i < maxlength.length; i++) {
            if (maxlength[i] == resultMaxLength) {
                result = result + cnt[i];
            }
        }
        return result;
    }
}
