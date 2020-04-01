package com.leetcode.bitmanipulation;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * <p>
 * Example 1
 * <p>
 * Input: [3,0,1]
 * Output: 2
 * Example 2
 * <p>
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * <p>
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class FindMissingNumber {

    /**
     * We all know that a^b^b =a, which means two xor operations with the same number will eliminate the number and reveal the original number.
     * In this solution, I apply XOR operation to both the index and value of the array.
     * In a complete array with no missing numbers, the index and value should be perfectly corresponding( nums[index] = index),
     * so in a missing array, what left finally is the missing number.
     *
     * @param nums
     * @return
     */
    public int missingNumberXor(int[] nums) {
        int i = 0;
        int result = 0;
        for (; i < nums.length; i++) {
            result = result ^ i ^ nums[i];
        }
        return result ^ i;
    }

    /**
     * Leetcode verified
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int max = nums.length;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        return ((max * (max + 1)) / 2) - sum;

    }

}
