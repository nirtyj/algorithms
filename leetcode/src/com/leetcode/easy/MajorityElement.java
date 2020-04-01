package com.leetcode.easy;

import java.util.Arrays;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {

    /**
     * Leetcode verified
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {

        int result = nums[0];
        int count = 0;

        for (int n : nums) {
            if (count == 0) {
                result = n;
                count++;
            } else if (result == n) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }

    public int majorityElement2(int[] num) {
        if (num.length == 1) {
            return num[0];
        }
        Arrays.sort(num);
        return num[num.length / 2];
    }
}
