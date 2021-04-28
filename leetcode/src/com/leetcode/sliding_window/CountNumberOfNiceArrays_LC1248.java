package com.leetcode.sliding_window;

/**
 * Given an array of integers nums and an integer k.
 * A continuous subarray is called nice if there are k odd numbers on it.
 *
 * Return the number of nice sub-arrays.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2,1,1], k = 3
 * Output: 2
 * Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
 * Example 2:
 *
 * Input: nums = [2,4,6], k = 1
 * Output: 0
 * Explanation: There is no odd numbers in the array.
 * Example 3:
 *
 * Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * Output: 16
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 */
public class CountNumberOfNiceArrays_LC1248 {

    /**
     * Double pass with AtMost logic
     */
    public int numberOfSubarrays(int[] nums, int k) {
        return numberOfSubarraysAtMostKOddNumbers(nums, k) - numberOfSubarraysAtMostKOddNumbers(nums, k-1);
    }

    public int numberOfSubarraysAtMostKOddNumbers(int[] A, int K) {
        int counter = 0;
        int begin = 0;
        int result = 0;
        for (int end = 0; end < A.length; end++) {
            if (A[end] % 2 != 0){
                counter++;
            }
            while (counter > K && begin <= end) {
                if (A[begin] % 2 != 0){
                    counter--;
                }
                begin++;
            }
            result = result + (end - begin + 1);
        }
        return result;
    }
    /**
     * When we find k odd numbers, we have one nice subarray, plus an additional subarray for each even number preceding
     * the first odd number. This is also true for each even number that follows.
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarraysSinglePass(int[] nums, int k) {
        int begin = 0;
        int counter = 0;
        int result = 0;
        int countEvenPrefixWhenOddIsK = 0;
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] % 2 != 0) {
                counter++;
                countEvenPrefixWhenOddIsK = 0; // needs to reset when you see a new odd because, if there is a even between 2 odd's that doesnt contribute to the result
            }

            while (begin <= end && counter == k) {
                if (nums[begin] % 2 != 0) {
                    counter--;
                }
                begin++;
                countEvenPrefixWhenOddIsK = countEvenPrefixWhenOddIsK + 1; // increase countEven only when counter == k.
            }
            result = result + countEvenPrefixWhenOddIsK; // countEven keeps track of previous evens and add them each time when you see a new even satisfying the condition.
        }
        return result;
    }
}
