package com.leetcode.binarysearch;

/**
 * A conveyor belt has packages that must be shipped from one port to another within D days.
 *
 * The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
 *
 * Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within D days.
 *
 *
 *
 * Example 1:
 *
 * Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * Output: 15
 * Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
 * 1st day: 1, 2, 3, 4, 5
 * 2nd day: 6, 7
 * 3rd day: 8
 * 4th day: 9
 * 5th day: 10
 *
 * Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
 */
public class CapacityToShipPackagesWithinDDays_LC1011 {

    /**
     * Binary search with a custom condition logic
     * @param weights
     * @param D
     * @return
     */
    public int shipWithinDays(int[] weights, int D) {
        int leftMinCapacity = 0;
        int rightMaxCapacity = 0;
        for(int w : weights){
            leftMinCapacity = Math.max(leftMinCapacity, w);
            rightMaxCapacity = rightMaxCapacity + w;
        }

        while(leftMinCapacity < rightMaxCapacity){
            int chosenMidCapacity = leftMinCapacity + (rightMaxCapacity - leftMinCapacity)/2;
            int daysNeeded = getDaysNeeded(weights, chosenMidCapacity);
            if (daysNeeded <= D){
                // if the days needed is less than or equal to allowed D, means that you have chosen more capacity
                // reduce the max capacity range to mid.
                rightMaxCapacity = chosenMidCapacity;
            } else {
                // if the days needed is greater than allowed D, means that you have chosen less capacity
                // increase the max capacity range to mid + 1
                leftMinCapacity = chosenMidCapacity + 1;
            }
        }
        return leftMinCapacity;
    }

    private int getDaysNeeded(int[] weights, int chosenMidCapacity) {
        int daysNeeded = 1;
        int currWeight = 0;
        // find how many days needed to ship with chosen mid capacity
        for(int w : weights){
            if (currWeight + w > chosenMidCapacity){ // if the weight exceeds the chosen weight, increase the days needed.
                daysNeeded = daysNeeded + 1;
                currWeight = 0;
            }
            currWeight = currWeight + w;
        }
        return daysNeeded;
    }
}
