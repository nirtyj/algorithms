package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/
public class TopKFrequentElements {

	/**
	 * Leetcode verified
	 * @param nums
	 * @param k
	 * @return
	 */
	public List<Integer> topKFrequent(int[] nums, int k) {
		 Map<Integer, Integer> map = new HashMap<>();
	        for(int n: nums){
	            map.put(n, map.getOrDefault(n,0)+1);
	        }
	           
	        // Prioirty Queue of Map entries - GENIUS!!
	        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
	                         new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
	        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
	            maxHeap.add(entry);
	        }
	        
	        List<Integer> res = new ArrayList<>();
	        while(res.size()<k){
	            Map.Entry<Integer, Integer> entry = maxHeap.poll();
	            res.add(entry.getKey());
	        }
	        return res;
	}
}
