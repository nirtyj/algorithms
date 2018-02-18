package leetcode.easy;

/**
A peak element is an element that is greater than its neighbors.
Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
You may imagine that num[-1] = num[n] = -∞.
*/
public class FindPeakElement {

	/**
	 * Leetcode verified
	 * 
	 * @param num
	 * @return
	 */
	public int findPeakElement(int[] num) {
		if (num.length <= 1)
			return 0;
		int mid = 0, l = 0, h = num.length - 1;
		while (l < h) {
			mid = l + (h - l) / 2;
			if (num[mid] > num[mid + 1])
				h = mid;
			else if (num[mid] < num[mid + 1])
				l = mid + 1;
		}
		return l;
	}
}
