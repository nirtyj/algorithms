package com.leetcode.medium;

/**
Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
*/
public class HIndexII {
	/**
	 * Leetcode verified - O(log n)
	 * @param citations
	 * @return
	 */
	public int hIndex(int[] citations) {
		int start = 0;
		int end = citations.length - 1;
		int len = citations.length;
		int result = 0;
		int mid;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (citations[mid] >= (len - mid)) {
				result = (len - mid);
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return result;
	}
}
