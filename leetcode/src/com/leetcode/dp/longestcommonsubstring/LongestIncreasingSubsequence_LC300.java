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
     * Patience sort - O(n log n)
     * https://leetcode.com/problems/longest-increasing-subsequence/discuss/74897/Fast-Java-Binary-Search-Solution-with-detailed-explanation
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        int dplen = 0;
        for(int i=0;i<nums.length;i++){
            int pos = Arrays.binarySearch(dp, 0, dplen, nums[i]);
            // if the key is not found, returns a negative insertionPointVal.
            if (pos < 0){
                pos =  (-(pos) - 1);
            }
            if (pos == dplen){
                dp[dplen] = nums[i];
                dplen++;
            } else {
                dp[pos] = nums[i];
            }
        }
        return dplen;
    }

    /**
     * Leetcode verified - O(n^2)
     *
     * @param nums
     * @return
     */
    public int lengthOfLISDP(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxVal = 1;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if (nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxVal = Math.max(dp[i], maxVal);
                }
            }
        }
        return maxVal;
    }

    /**
     * Memoization for recursion
     * @param nums
     * @return
     */
    public int lengthOfLISMemoized(int[] nums) {
        Integer[][] dp = new Integer[nums.length][nums.length+1];
        return findLISLengthRecursive(nums, 0, -1, dp);
    }

    private int findLISLengthRecursive(int[] nums, int currentIndex, int previousIndex, Integer[][] dp) {
        if(currentIndex == nums.length)
            return 0;

        if (dp[currentIndex][previousIndex+1] != null){
            return dp[currentIndex][previousIndex+1];
        }
        // include nums[currentIndex] if it is larger than the last included number
        int c1 = 0;
        if(previousIndex == -1 || nums[currentIndex] > nums[previousIndex])
            c1 = 1 + findLISLengthRecursive(nums, currentIndex+1, currentIndex, dp);

        // excluding the number at currentIndex
        int c2 = findLISLengthRecursive(nums, currentIndex+1, previousIndex, dp);

        dp[currentIndex][previousIndex+1] = Math.max(c1, c2);
        return dp[currentIndex][previousIndex+1];
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
