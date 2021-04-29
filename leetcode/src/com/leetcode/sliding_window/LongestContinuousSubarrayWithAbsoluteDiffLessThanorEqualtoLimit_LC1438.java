package com.leetcode.sliding_window;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeSet;

/**
 * Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray such that the absolute difference between any two elements of this subarray is less than or equal to limit.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [8,2,4,7], limit = 4
 * Output: 2
 * Explanation: All subarrays are:
 * [8] with maximum absolute diff |8-8| = 0 <= 4.
 * [8,2] with maximum absolute diff |8-2| = 6 > 4.
 * [8,2,4] with maximum absolute diff |8-2| = 6 > 4.
 * [8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
 * [2] with maximum absolute diff |2-2| = 0 <= 4.
 * [2,4] with maximum absolute diff |2-4| = 2 <= 4.
 * [2,4,7] with maximum absolute diff |2-7| = 5 > 4.
 * [4] with maximum absolute diff |4-4| = 0 <= 4.
 * [4,7] with maximum absolute diff |4-7| = 3 <= 4.
 * [7] with maximum absolute diff |7-7| = 0 <= 4.
 * Therefore, the size of the longest subarray is 2.
 */
public class LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit_LC1438 {

    /**
     * Best solution with 2 queues to maintain min + max
     */
    public int longestSubarray(int[] nums, int limit) {
        int max = 0;
        int begin = 0;
        Deque<Integer> maxd = new ArrayDeque<>(); // LinkedList also to maintain maxes.
        Deque<Integer> mind = new ArrayDeque<>(); // LinkedList also to maintain mins.
        for (int end = 0; end < nums.length; end++) {

            while (!maxd.isEmpty() && nums[end] > maxd.peekLast()) // pops until this is bigger
                maxd.pollLast();
            while (!mind.isEmpty() && nums[end] < mind.peekLast()) // pops until this is the lower.
                mind.pollLast();

            maxd.add(nums[end]); // add right now.
            mind.add(nums[end]); // add right now.

            while (Math.abs(maxd.peek() - mind.peek()) > limit && begin <= end) { // find the lowest - highest diff
                if (maxd.peek() == nums[begin]) // if the left is bigger one, remove that.
                    maxd.pollFirst();
                if (mind.peek() == nums[begin]) // if the left is smaller one, remove that.
                    mind.pollFirst();
                begin++;
            }
            max = Math.max(max, end - begin + 1);  // compute max
        }
        return max;
    }

    /**
     * NlogN solution with Treeset sorting.
     * N can be achieved by keeping 2 dequeue's one for min so far. one for max so far.
     * @param nums
     * @param limit
     * @return
     */
    public int longestSubarraySorting(int[] nums, int limit) {
        int max = 0;
        int left = 0;
        // compare array values. if same, return the first index.
        TreeSet<Integer> set = new TreeSet<>((a, b) -> Integer.compare(nums[a], nums[b]) == 0 ? Integer.compare(a, b) : Integer.compare(nums[a], nums[b]));
        for (int right = 0; right < nums.length; right++) {
            set.add(right); // add right everytime.
            while (Math.abs(nums[set.first()] - nums[set.last()]) > limit && left <= right) { // find the lowest - highest diff
                set.remove(left); // increase the left counter by removing from the set.
                left++;
            }
            max = Math.max(max, right - left + 1);  // compute max
        }
        return max;
    }

    /**
     * Naive - O(n*n)
     */
    public int longestSubarrayNaive(int[] nums, int limit) {

        int lowest = nums[0];
        int highest = nums[0];
        int max = 0;
        int j=0;
        for(int i=0;i<nums.length;i++){
            lowest = Math.min(lowest, nums[i]);
            highest = Math.max(highest, nums[i]);
            if  (Math.abs(lowest - highest) <= limit){
                max = Math.max(max, i-j+1);
            } else {
                while(Math.abs(lowest - highest) > limit && j <= i){
                    j++;
                    lowest = findLowest(nums, j , i);
                    highest = findHighest(nums, j, i);
                }
                if  (Math.abs(lowest - highest) <= limit){
                    max = Math.max(max, i-j+1);
                }
            }
        }
        return max;
    }

    int findLowest(int[] nums, int start,int end){
        int low = Integer.MAX_VALUE;
        for(int i= start; i <= end; i++){
            low = Math.min(low, nums[i]);
        }
        return low;
    }

    int findHighest(int[] nums,int start,int end){
        int high = Integer.MIN_VALUE;
        for(int i= start; i <= end; i++){
            high = Math.max(high, nums[i]);
        }
        return high;
    }
}
