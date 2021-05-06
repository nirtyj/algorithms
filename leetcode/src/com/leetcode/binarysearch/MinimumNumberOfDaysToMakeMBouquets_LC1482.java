package com.leetcode.binarysearch;

/**
 * Given an integer array bloomDay, an integer m and an integer k.
 *
 * We need to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
 *
 * The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
 *
 * Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
 * Output: 3
 * Explanation: Let's see what happened in the first three days. x means flower bloomed and _ means flower didn't bloom in the garden.
 * We need 3 bouquets each should contain 1 flower.
 * After day 1: [x, _, _, _, _]   // we can only make one bouquet.
 * After day 2: [x, _, _, _, x]   // we can only make two bouquets.
 * After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.
 */
public class MinimumNumberOfDaysToMakeMBouquets_LC1482 {

    /**
     * Binary search for days that can satisfy the number of days to make bouquets.
     * k is used calculate a specific condition.
     * @param bloomDay
     * @param m
     * @param k
     * @return
     */
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) {
            return -1;
        }
        int leftMinDay = Integer.MAX_VALUE;
        int rightMaxDay = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            leftMinDay = Math.min(leftMinDay, day); // minimum days to bloom
            rightMaxDay = Math.max(rightMaxDay, day); // max days to bloom
        }
        while (leftMinDay < rightMaxDay) {
            int chosenDay = leftMinDay + (rightMaxDay - leftMinDay) / 2;
            // for chosen day, can we find how many Bouquet can be made.
            int bouquetMade = getNumberOfBouquetMade(bloomDay, k, chosenDay);
            if (bouquetMade >= m) { // if bouquets made is greater than equal, trim the max number of days to chosen
                rightMaxDay = chosenDay;
            } else {
                leftMinDay = chosenDay + 1;
            }
        }
        return leftMinDay;// minimum days to create bouquets needed
    }

    int getNumberOfBouquetMade(int[] bloomday, int k, int chosenDay) {
        int bouquet = 0;
        int adjWindow = 0;
        for (int i = 0; i < bloomday.length; i++) {
            if (bloomday[i] > chosenDay) { // everytime, the day value is higher than chosen Day, reset the sliding window
                adjWindow = 0; // reset
            } else {
                adjWindow++;
                if (adjWindow == k) { // if the adjacent window satisfies the count of given k, we made one bouquet
                    bouquet++;
                    adjWindow = 0;
                }
            }
        }
        return bouquet;
    }
}
