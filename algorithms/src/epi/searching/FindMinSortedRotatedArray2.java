package epi.searching;

public class FindMinSortedRotatedArray2 {

	/**
	 * Leetcode verified
	 * 
	 * @param list
	 * @return
	 */
	public int findMin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {

			// handle cases like [3, 1, 3]
			while (nums[left] == nums[right] && left != right) {
				left++;
			}

			if (nums[left] <= nums[right]) {
				return nums[left];
			}

			int middle = (left + right) / 2;
			if (nums[middle] >= nums[left]) {
				left = middle + 1;
			} else {
				right = middle;
			}
		}

		return -1;
	}
}