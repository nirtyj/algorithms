package com.leetcode.medium;

/**
 * 334. https://leetcode.com/problems/increasing-triplet-subsequence/description/
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * <p>
 * Formally the function should:
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * <p>
 * Examples:
 * Given [1, 2, 3, 4, 5],
 * return true.
 * <p>
 * Given [5, 4, 3, 2, 1],
 * return false.
 */
public class IncreasingTripletSequence_334 {

    /**
     * Leetcode verified
     * min, second min - does not hold the correct values of the sequence.
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min)
                min = num;
            else if (num < secondMin)
                secondMin = num;
            else if (num > secondMin)
                return true;
        }
        return false;
    }

    /**
     * Find the triplet sequences
     *
     * @param arrA
     */
    public void triplet(int[] arrA) {
        int[] Lmin = new int[arrA.length];
        int[] Rmax = new int[arrA.length];
        int leftMinIndex = 0;
        int leftMinValue = arrA[0];
        int rightMaxValue = arrA[arrA.length - 1];
        int rightMaxIndex = arrA.length - 1;

        // traverse the main array and fill the Lmin array with the index
        // position which has the minimum value so far
        for (int i = 0; i < arrA.length; i++) {
            if (leftMinValue > arrA[i]) {
                leftMinIndex = i;
                leftMinValue = arrA[i];
            }
            Lmin[i] = leftMinIndex;
        }
        // System.out.println(Arrays.toString(Lmin));
        // traverse the main array backwords and fill the Rmax array with the
        // index position which has the maximun value so far
        for (int i = arrA.length - 1; i >= 0; i--) {
            if (rightMaxValue < arrA[i]) {
                rightMaxIndex = i;
                rightMaxValue = arrA[i];
            }
            Rmax[i] = rightMaxIndex;
        }
        // Now Traverse the main array and check for the element with the
        // following condition and print it.
        // arrA[Lmin[i]] < arrA[i] && arrA[Rmax[i]] > arrA[i]

        for (int i = 0; i < arrA.length; i++) {
            if (arrA[Lmin[i]] < arrA[i] && arrA[Rmax[i]] > arrA[i]) {
                System.out.println("Triplet " + arrA[Lmin[i]] + "  " + arrA[i]
                        + "  " + arrA[Rmax[i]]);
                return;
            }
        }
    }
}
