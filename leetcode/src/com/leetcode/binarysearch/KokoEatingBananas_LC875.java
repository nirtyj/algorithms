package com.leetcode.binarysearch;

/**
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
 *
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 *
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 *
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 *
 *
 *
 * Example 1:
 *
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 */
public class KokoEatingBananas_LC875 {

    /**
     * Binary Search
     * @param piles
     * @param h
     * @return
     */
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Integer.MIN_VALUE;
        for (int b : piles) {
            right = Math.max(right, b);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int hrsNeeded = getHoursNeededWithCapacity(piles, mid);
            if (hrsNeeded <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    int getHoursNeededWithCapacity(int[] piles, int capacityPerHour) {
        int hrsNeeded = 0;
        for (int b : piles) {
            hrsNeeded = hrsNeeded + (b / capacityPerHour);
            if (b % capacityPerHour != 0)
                hrsNeeded++;
        }
        return hrsNeeded;
    }
}
