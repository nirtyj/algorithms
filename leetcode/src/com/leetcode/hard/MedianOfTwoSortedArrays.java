package com.leetcode.hard;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {

    /**
     * Leetcode verified - O(log (min (x,y))
     * From : https://www.youtube.com/watch?v=LPFhl65R7ww
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // always makes sure first array is smaller.
        // That is the base to figure out how to split on the longer array
        if (nums2.length < nums1.length)
            return findMedianSortedArrays(nums2, nums1);

        int x = nums1.length;
        int y = nums2.length;

        // low and high always track the smaller array
        int low = 0;
        int high = x;

        while (low <= high) {
            // binary search kinda .. split middle
            int partitionX = (low + high) / 2;

            // partitionX + partitionY = (x + y + 1)/2
            // based on partition x, you calculate the Y partition
            int partitionY = (x + y + 1) / 2 - partitionX;

            // now find the max left and min right based on partition X
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            // now find the max left and min right based on partition Y
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            // valid condition for median
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in
                // case of even length combined array size
                // or get max of left for odd length combined array size.
                if ((x + y) % 2 == 0) {
                    // cast to double very important cos of MIN_VALUE + MAX_VALUE 's
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                // reduce the right of smaller array
                high = partitionX - 1;
            } else {
                // increase the left of smaller array
                low = partitionX + 1;
            }
        }
        throw new IllegalArgumentException();
    }
}
