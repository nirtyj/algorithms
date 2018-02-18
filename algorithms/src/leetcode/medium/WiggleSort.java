package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;

/**
Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
*/
public class WiggleSort {
	
	public void wiggleSort(int[] nums) {
		// true - up; false - down
		boolean upordown = true;
		for (int i = 1; i < nums.length; i++) {
			if (upordown) {
				// up
				upordown = !upordown;
				if (nums[i] > nums[i - 1]) {
					continue;
				} else {
					xwap(nums, i);
				}
			} else {
				// down
				upordown = !upordown;
				if (nums[i] < nums[i - 1]) {
					continue;
				} else {
					xwap(nums, i);
				}
			}
		}
	}

	private void xwap(int[] a, int i) {
		int t = a[i];
		a[i] = a[i - 1];
		a[i - 1] = t;
	}
	
	/**
	 * Leetcode verified - O( n log n)
	 * @param nums
	 */
	public void wiggleSort1(int[] nums) {
		ArrayList<Integer> numsre = new ArrayList<>();
		for(int i : nums)
			numsre.add(i);
		
		Collections.sort(numsre);
		
		int n = 0;
		for(int i=0;i<nums.length;i = i+2, n++)
			nums[i] = numsre.get(n);
		
		for(int i=1;i<nums.length;i = i+2, n++)
			nums[i] = numsre.get(n);

	}
}
