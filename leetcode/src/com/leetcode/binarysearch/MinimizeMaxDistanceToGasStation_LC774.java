package com.leetcode.binarysearch;

/**
 * You are given an integer array stations that represents the positions of the gas stations on the x-axis. You are also given an integer k.
 *
 * You should add k new gas stations. You can add the stations anywhere on the x-axis, and not necessarily on an integer position.
 *
 * Let penalty() be the maximum distance between adjacent gas stations after adding the k new stations.
 *
 * Return the smallest possible value of penalty(). Answers within 10-6 of the actual answer will be accepted.
 *
 *
 *
 * Example 1:
 *
 * Input: stations = [1,2,3,4,5,6,7,8,9,10], k = 9
 * Output: 0.50000
 * Example 2:
 *
 * Input: stations = [23,24,36,39,46,56,57,65,84,98], k = 1
 * Output: 14.00000
 */
public class MinimizeMaxDistanceToGasStation_LC774 {

    /**
     * @param stations
     * @param k
     * @return
     */
    public double minmaxGasDist(int[] stations, int k) {
        double left = 0; // min Penalty
        double right = 0; // max Penalty
        for(int i = 0; i < stations.length - 1; i++)
            right = Math.max(right, stations[i + 1] - stations[i]); // find max penalty .i.e max distance between 2 stations.

        while(right - left > 1e-6){ // do as long as the difference is less than 10^-6.
            double mid = left + (right - left) / 2; // middle Penalty
            int possibleStations = getNumberOfStationsPossibleToInsert(stations, mid);
            if(possibleStations <= k){ // no of stations possible to insert is less than needed, hence reduce the window on the right
                right = mid;
            } else { // no of stations possible to insert is greater, reduce the window from left
                left = mid; // no + 1 because double
            }
        }
        return left;
    }

    private int getNumberOfStationsPossibleToInsert(int[] stations, double penalty){
        int count = 0;
        for(int i = 0; i < stations.length - 1; i++){
            int space = stations[i + 1] - stations[i];
            if(space > penalty){
                count += Math.floor(space / penalty); // how many possibe to insert with a given penalty
            }
        }
        return count;
    }
}
