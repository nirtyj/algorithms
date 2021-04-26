package com.leetcode.sliding_window;

import java.util.Arrays;

/**
 * The frequency of an element is the number of times it occurs in an array.
 *
 * You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.
 *
 * Return the maximum possible frequency of an element after performing at most k operations.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,4], k = 5
 * Output: 3
 * Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
 * 4 has a frequency of 3.
 * Example 2:
 *
 * Input: nums = [1,4,8,13], k = 5
 * Output: 2
 * Explanation: There are multiple optimal solutions:
 * - Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2.
 * - Increment the second element four times to make nums = [1,8,8,13]. 8 has a frequency of 2.
 * - Increment the third element five times to make nums = [1,4,13,13]. 13 has a frequency of 2.
 * Example 3:
 *
 * Input: nums = [3,9,6], k = 2
 * Output: 1
 */
public class FrequencyOfTheMostFrequentElement_LC1838 {

    /**
     * Sliding Window optimal
     * @param A
     * @param k
     * @return
     */
    public int maxFrequency(int[] A, int k) {
        int res = 1, left = 0;
        long sumOfElementsInWindow = 0;
        Arrays.sort(A);
        for (int right = 0; right < A.length; ++right) {
            sumOfElementsInWindow += A[right];
            // increase the left pointer until the condition satisfies
            while (getNumberOfOperationsNeeded(left, right, sumOfElementsInWindow, A) > k) {
                sumOfElementsInWindow -= A[left];
                left += 1;
            }
            res = Math.max(res, right - left + 1); // update the window if its the max window
        }
        return res;
    }

    /**
     Number of operations needed for all elements in the window [startIndex, endIndex] to hit A[endIndex]
     Example:
     Consider arr with [1, 2, 3, 4] with startIndex = 0; endIndex = 3: i.e If 1, 2, 3 wants to become 4.
     Number of operations needed
     = (4-1)+(4-2)+(4-3)+(4-4)) = 6.
     =  4 + 4 + 4 + 4 - (1 + 2 + 3+ 4)
     = 4 * 4 - (1 + 2 + 3 + 4)
     = (number of elements) * ElementToReach - sum of elements in the window
     */
    long getNumberOfOperationsNeeded(int startIndex, int endIndex, long sumOfElementsInWindow, int[] A){
        int numberOfElements = endIndex - startIndex + 1;
        int elementToReach = A[endIndex];
        return ((long) numberOfElements * elementToReach) - sumOfElementsInWindow;
    }

    /**
     * Sliding Window with break condition O(n*n)
     * @param nums
     * @param k
     * @return
     */
    public int maxFrequencyONN(int[] nums, int k) {
        Arrays.sort(nums);
        int max = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            double sum = 0;
            if (max <= j + 1) { // limit going through the lower numbers once you find the bigger max.
                for (int i = j; i >= 0; i--) {
                    sum = sum + (nums[j] - nums[i]);
                    if (sum <= k) {
                        max = Math.max(max, j - i + 1);
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        return max;
    }

    /**
     * Sliding window time limit exceeded
     */
    public int maxFrequencyTimeLimitExceeded(int[] nums, int k) {
        Arrays.sort(nums);
        int max = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            double sum = 0;
            for (int i = j; i >= 0; i--) {
                sum = sum + (nums[j] - nums[i]);
                if (sum <= k) {
                    max = Math.max(max, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return max;
    }

    /**
     * DP solution - memory limit exceeded
     * @param nums
     * @param k
     * @return
     */
    public int maxFrequencyDP(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                dp[i][j] = nums[j] - nums[i];
            }
        }
        int max = 1;
        for (int j = 0; j < nums.length; j++) {
            double sum = 0;
            for (int i = j; i >= 0; i--) {
                sum = sum + dp[i][j];
                if (sum <= k) {
                    max = Math.max(max, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return max;
    }
}
