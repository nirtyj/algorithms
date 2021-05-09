package com.leetcode.binarysearch;

import java.util.Arrays;

/**
 * Given an integer array, return the k-th smallest distance among all the pairs. The distance of a pair (A, B) is defined as the absolute difference between A and B.
 *
 * Example 1:
 * Input:
 * nums = [1,3,1]
 * k = 1
 * Output: 0
 * Explanation:
 * Here are all the pairs:
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * Then the 1st smallest distance pair is (1,1), and its distance is 0.
 */
public class FindKthSmallestPairDistance_LC719 {

    /**
     * Binary search after sorting.
     * n log n + log n * (n) = n log n
     * @param nums
     * @param k
     * @return
     */
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        // difference between elements is the search space

        // can be 0 as thats the min possible or find min possible form the given nums.
        int left = 0;
        left = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            left = Math.min(left, nums[i] - nums[i - 1]);
        }
        // max diff will be between last and first element
        int right = nums[nums.length - 1] - nums[0];

        while(left < right){
            int middle = left + (right - left) / 2;
            int count = findCount(nums, middle);
            if (count >= k){
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    /**
     * Sliding window and hence O(n)
     * @param nums
     * @param mid
     * @return
     */
    int findCount(int[] nums, int mid){
        int res = 0;
        for (int start = 0,end = 0; start < nums.length; start++) {
            while (end < nums.length && nums[end] - nums[start] <= mid) {
                end++;
            }
            res += end - start - 1; // reduce 1 as j exceeds at this point
        }
        return res;
    }
}
