package com.leetcode.binarysearch;

/**
 * Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.
 *
 * Write an algorithm to minimize the largest sum among these m subarrays.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [7,2,5,10,8], m = 2
 * Output: 18
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 */
public class SplitArrayLargestSum_LC410 {

    /**
     * Very similar to LC 1011
     * @param nums
     * @param m
     * @return
     */
    public int splitArray(int[] nums, int m) {
        int leftMinCapacity = 0;
        int rightMaxCapacity = 0;
        for (int w : nums) {
            leftMinCapacity = Math.max(leftMinCapacity, w);
            rightMaxCapacity = rightMaxCapacity + w;
        }
        while (leftMinCapacity < rightMaxCapacity) {
            int chosenMidCapacity = leftMinCapacity + (rightMaxCapacity - leftMinCapacity) / 2;
            int mNeeded = getMNeeded(nums, chosenMidCapacity);
            if (mNeeded <= m) {
                // if the m needed is less than or equal to allowed m, means that you have chosen more capacity
                // reduce the max capacity range to mid.
                rightMaxCapacity = chosenMidCapacity;
            } else {
                // if the m needed is greater than allowed m, means that you have chosen less capacity
                // increase the max capacity range to mid + 1
                leftMinCapacity = chosenMidCapacity + 1;
            }
        }
        return leftMinCapacity;
    }

    private int getMNeeded(int[] weights, int chosenMidCapacity) {
        int mNeeded = 1;
        int currWeight = 0;
        // find how many days needed to ship with chosen mid capacity
        for (int w : weights) {
            if (currWeight + w > chosenMidCapacity) { // if the weight exceeds the chosen weight, increase the days needed.
                mNeeded = mNeeded + 1;
                currWeight = 0;
            }
            currWeight = currWeight + w;
        }
        return mNeeded;
    }
}
