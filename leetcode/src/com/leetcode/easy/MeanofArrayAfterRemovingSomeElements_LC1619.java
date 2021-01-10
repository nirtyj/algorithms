package com.leetcode.easy;

import java.util.Arrays;

/**
 * Given an integer array arr, return the mean of the remaining integers after removing the smallest 5% and the largest 5% of the elements.
 *
 * Answers within 10-5 of the actual answer will be considered accepted.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3]
 * Output: 2.00000
 * Explanation: After erasing the minimum and the maximum values of this array, all elements are equal to 2, so the mean is 2.
 */
public class MeanofArrayAfterRemovingSomeElements_LC1619 {

    /**
     * @param arr
     * @return
     */
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int low = (arr.length * 5) / 100;
        int start = low;
        int end = arr.length - low;
        double sum = 0.0;
        int count = 0;
        for (int i = start; i < end; i++, count++){
            sum = sum + arr[i];
        }
        return sum /count;
    }
}
