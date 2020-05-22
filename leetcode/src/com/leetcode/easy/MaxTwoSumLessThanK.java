package com.leetcode.easy;

import java.util.Arrays;

/**
 * Given an array A of integers and integer K, return the maximum S such
 * that there exists i < j with A[i] + A[j] = S and S < K. If no i, j exist satisfying this equation, return -1.
 * Example 1:
 *
 * Input: A = [34,23,1,24,75,33,54,8], K = 60
 * Output: 58
 * Explanation:
 * We can use 34 and 24 to sum 58 which is less than 60.
 * Example 2:
 *
 * Input: A = [10,20,30], K = 15
 * Output: -1
 * Explanation:
 * In this case it's not possible to get a pair sum less that 15.
 *
 *
 * Note:
 *
 * 1 <= A.length <= 100
 * 1 <= A[i] <= 1000
 * 1 <= K <= 2000
 */
public class MaxTwoSumLessThanK {

    /**
     * 2ms
     * @param A
     * @param K
     * @return
     */
    public int twoSumLessThanKEasy(int[] A, int K) {
        if (A.length < 1)
            return -1;
        Arrays.sort(A);
        int i = 0;
        int j = A.length - 1;
        int sum = -1;
        while (i < j) {
            int newSum = A[i] + A[j];
            if (newSum < K) {
                sum = Math.max(sum, newSum);
                i++;
            } else {
                j--;
            }
        }
        return sum;
    }

    /**
     * 2ms
     * @param A
     * @param K
     * @return
     */
    public int twoSumLessThanKBinarySearch(int[] A, int K) {
        int result = -1;
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++)
        {
            int currentVal = A[i];
            int left = i + 1;
            int right = A.length - 1;
            while (left <= right)
            {
                int mid = left + (right - left) / 2;
                int sum =  currentVal + A[mid];
                if (sum < K)
                {
                    left = mid + 1;
                    result = Math.max(result, sum);
                }
                else
                {
                    right = mid - 1;
                }
            }
        }
        return result;
    }
}
