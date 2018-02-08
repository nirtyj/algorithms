package leetcode.dynamic_programming;

public class LongestContinuousIncreasingSubsequence {

	/**
	 * Leetcode verified
	 * @param nums
	 * @return
	 */
	public int findLengthOfLCIS(int[] nums) {
		int length = 0;
		int tmp = 1;
		if (nums.length == 0)
			return 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] < nums[i + 1]) {
				tmp++;
				length = Math.max(length, tmp);
			}
			else if (nums[i] >= nums[i + 1]) {
				tmp = 1;
			}
		}
		return Math.max(length, 1);
	}
}
