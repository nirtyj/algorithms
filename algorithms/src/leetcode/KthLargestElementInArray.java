package leetcode;

import java.util.PriorityQueue;

public class KthLargestElementInArray {

	/**
	 * Leetcode verified
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
