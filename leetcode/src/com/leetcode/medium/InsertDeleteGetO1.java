package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
/**
Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
*/
class InsertDeleteGetO1 {
	
	ArrayList<Integer> nums;
	HashMap<Integer, Integer> valToIndex;
	java.util.Random rand = new java.util.Random();

	/** Leetcode verified */
	public InsertDeleteGetO1() {
		nums = new ArrayList<Integer>();
		valToIndex = new HashMap<Integer, Integer>();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {
		if(valToIndex.containsKey(val))
			return false;
		nums.add(val);
		valToIndex.put(val, nums.size() - 1);
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val) {
		if (!valToIndex.containsKey(val))
			return false;
		int loc = valToIndex.get(val);
		// if its in between, remove the last one and replace in that position and update that new location
		if (loc < nums.size() - 1) {
			int lastone = nums.get(nums.size() - 1);
			nums.set(loc, lastone);
			valToIndex.put(lastone, loc);
		}
		// else it is the last one. just remove it 
		valToIndex.remove(val);
		nums.remove(nums.size() - 1);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return nums.get(rand.nextInt(nums.size()));
	}
}