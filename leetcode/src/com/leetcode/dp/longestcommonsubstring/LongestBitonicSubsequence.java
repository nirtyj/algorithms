package com.leetcode.dp.longestcommonsubstring;

import java.util.Arrays;

/**
 * Given a number sequence, find the length of its Longest Bitonic Subsequence (LBS). A subsequence is considered bitonic if it is monotonically increasing and then monotonically decreasing.
 *
 * Example 1:
 *
 * Input: {4,2,3,6,10,1,12}
 * Output: 5
 * Explanation: The LBS is {2,3,6,10,1}.
 *
 * Example 2:
 *
 * Input: {4,2,5,9,7,6,10,3,1}
 * Output: 7
 * Explanation: The LBS is {4,5,9,7,6,3,1}.
 */
public class LongestBitonicSubsequence {

    /**
     * Bottom up DP
     * @param nums
     * @return
     */
    private int findLBSLengthBottomUp(int[] nums){
        if (nums.length  <= 1){
            return 0;
        }
        int[] front = new int[nums.length];
        int[] end = new int[nums.length];
        for(int i=1;i<nums.length;i++){
            if(nums[i] > nums[i-1]){
                front[i] = 1 + front[i-1];
            } else {
                front[i] = front[i-1];
            }
        }
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i] > nums[i+1]){
                end[i] = 1 + end[i+1];
            } else {
                end[i] = end[i+1];
            }
        }
        int max = 0;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max, front[i] + end[i] + 1);
        }
        return max;
    }

    /**
     * Recursion with memoization
     * @param nums
     * @return
     */
    private int findLBSLengthMemo(int[] nums) {
        if (nums.length  == 0){
            return 0;
        }
        if (nums.length == 1){
            return 1;
        }
        int max = 1;
        int[] front = new int[nums.length];
        int[] end = new int[nums.length];
        Arrays.fill(front, -1);
        Arrays.fill(end, -1);
        for(int i=0;i<nums.length;i++){
            int c1 = findLDSGoingFrontMemo(nums, i - 1, i, front);
            int c2 = findLDSGoingEndMemo(nums, i +1, i, end);
            max = Math.max(max, c1 + c2 + 1);
        }
        return max;
    }

    private int findLDSGoingFrontMemo(int[] nums, int current, int prev,  int[] front){
        if (current < 0  || current >=  nums.length || prev <0 || prev >= nums.length){
            return 0;
        }
        if (front[current] != -1){
            return front[current];
        }
        if (nums[current] < nums[prev]){
            front[current] = Math.max(front[current], 1 + findLDSGoingFrontMemo(nums, current -1, current, front));
        }
        front[current] = Math.max(front[current], findLDSGoingFrontMemo(nums, current -1, current, front));
        return front[current];
    }

    private int findLDSGoingEndMemo(int[] nums, int current, int prev, int[] end){
        if (current < 0  || current >=  nums.length || prev <0 || prev >= nums.length){
            return 0;
        }
        if (end[current] != -1){
            return end[current];
        }
        if (nums[prev] > nums[current]){
            end[current] = Math.max(end[current], 1 + findLDSGoingEndMemo(nums, current + 1, current, end));
        }
        end[current] = Math.max(end[current], findLDSGoingEndMemo(nums, current + 1, current, end));
        return end[current];
    }
    /**
     * Naive recursion
     * @param nums
     * @return
     */
    private int findLBSLength(int[] nums) {
        if (nums.length  == 0){
            return 0;
        }
        if (nums.length == 1){
            return 1;
        }
        int max = 1;
        for(int i=0;i<nums.length;i++){
            int c1 = findLDSGoingFront(nums, i - 1, i);
            int c2 = findLDSGoingEnd(nums, i +1, i);
            max = Math.max(max, c1 + c2 + 1);
        }
        return max;
    }

    private int findLDSGoingFront(int[] nums, int current, int prev){
        if (current < 0  || current >=  nums.length || prev <0 || prev >= nums.length){
            return 0;
        }
        if (nums[current] < nums[prev]){
            return 1 + findLDSGoingFront(nums, current -1, current);
        }
        return findLDSGoingFront(nums, current -1, current);
    }

    private int findLDSGoingEnd(int[] nums, int current, int prev){
        if (current < 0  || current >=  nums.length || prev <0 || prev >= nums.length){
            return 0;
        }
        if (nums[prev] > nums[current]){
            return 1 + findLDSGoingEnd(nums, current + 1, current);
        }
        return findLDSGoingEnd(nums, current + 1, current);
    }

    public static void main(String[] args) {
        LongestBitonicSubsequence lbs = new LongestBitonicSubsequence();
        int[] nums = {4,2,3,6,10,1,12};
        System.out.println(lbs.findLBSLengthBottomUp(nums));
        nums = new int[]{4,2,5,9,7,6,10,3,1};
        System.out.println(lbs.findLBSLengthBottomUp(nums));
    }
}
