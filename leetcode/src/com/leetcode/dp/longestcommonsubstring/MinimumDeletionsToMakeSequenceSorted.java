package com.leetcode.dp.longestcommonsubstring;

/**
 * Problem Statement #
 * Given a number sequence, find the minimum number of elements that should be deleted to make the remaining sequence sorted.
 *
 * Example 1:
 *
 * Input: {4,2,3,6,10,1,12}
 * Output: 2
 * Explanation: We need to delete {4,1} to make the remaing sequence sorted {2,3,6,10,12}.
 */
public class MinimumDeletionsToMakeSequenceSorted {

    public static void main(String[] args) {
        MinimumDeletionsToMakeSequenceSorted mdss = new MinimumDeletionsToMakeSequenceSorted();
        int[] nums = {4,2,3,6,10,1,12};
        System.out.println(mdss.findMinimumDeletions(nums));
        nums = new int[]{-4,10,3,7,15};
        System.out.println(mdss.findMinimumDeletions(nums));
        nums = new int[]{3,2,1,0};
        System.out.println(mdss.findMinimumDeletions(nums));
    }

    private int findMinimumDeletions(int[] nums) {
       return nums.length - LongestIncreasingSubsequence_LC300.lengthOfLIS(nums);
    }
}
