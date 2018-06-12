package com.leetcode.medium;

import java.util.PriorityQueue;
import java.util.Random;
/**
215. https://leetcode.com/problems/kth-largest-element-in-an-array/description/
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/
public class KthLargestElementInArray_215 {

	/**
	 * Best - O(n) - Quick select Algorithm
	 * @param nums
	 * @param k
	 * @return
	 */
	public int findKthLargestBest(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return -1;
        int i = 0;
        int j = nums.length - 1;
        k = nums.length - k;
        shuffle(nums);
        while(i<j)
        {
            int pivot = randomPivot(i, j);
            int index = partition(nums, i, j, pivot);
            if(index == k)
                break;
            else if(index < k)
                i = index + 1;
            else
                j = index - 1;
        }
        return nums[k];
    }
    
    private int partition(int[] nums, int left, int right, int pivotIndex)
    {
        int pivotValue = nums[pivotIndex];
        swap(nums, right, pivotIndex);
        int storeIndex = left;
        for(int i = left; i<right; i++)
        {
            if(nums[i]<pivotValue)
            {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }
        swap(nums, storeIndex, right);
        return storeIndex;
    }
    
  
    private void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private int randomPivot(int i, int j)
    {
        Random r = new Random();
        return i + r.nextInt(j-i+1);
    }

    // fisher yates shuffling algorithm
    private void shuffle(int a[]) {
        final Random random = new Random();
        for(int ind = a.length - 1; ind > 0; ind--) {
            int r = random.nextInt(ind);
            swap(a, ind, r);
        }
    }
    
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
	
	
}
