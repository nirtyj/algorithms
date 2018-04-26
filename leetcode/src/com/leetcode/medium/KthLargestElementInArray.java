package com.leetcode.medium;

import java.util.PriorityQueue;
/**
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/
public class KthLargestElementInArray {

	/**
	 * Leetcode verified - nlog (k)
	 * @param nums
	 * @param k
	 * @return
	 */
	public int findKthLargest(int[] nums, int k) {
		// min heap - everything is higer in min heap than the root
	    PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
	    for(int i: nums){
	        q.offer(i);
	 
	        if(q.size()>k){
	            q.poll();
	        }
	    }
	    return q.peek();
	}
	
	public int findKthLargestPivot(int[] nums, int k) {
        if(nums==null || k>nums.length)
            return -1;
        return partitionHelper(nums, k, 0, nums.length-1);
    }
    private int partitionHelper(int[] nums, int k, int start, int end) {
        int mid = nums[(start+end)/2];
        int left = start, right = end;
        while(left<=right) {
            while(left<=right && nums[left]>mid) {
                left++;
            }
            while(left<=right && nums[right]<mid) {
                right--;
            }
            if(left<=right) {
                int temp = nums[left];
                nums[left++] = nums[right];
                nums[right--] = temp;
            }
        }

        if(right - start +1 >= k)
            return partitionHelper(nums, k, start, right);
        if(left - start < k)
            return partitionHelper(nums, k-(left-start), left, end);
        return nums[right+1];
        
    }
}
