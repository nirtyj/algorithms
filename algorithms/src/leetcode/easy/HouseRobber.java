package leetcode.easy;

/**
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, 
the only constraint stopping you from robbing each of them is that adjacent houses have security system connected
 and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
*/
public class HouseRobber {

	/**
	 * Leetcode verified
	 * @param nums
	 * @return
	 */
	public static int rob(int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 1)
			return Math.max(nums[0], nums[1]);

		int max = Math.max(nums[0], nums[1]);
		int[] vals = new int[nums.length];
		vals[0] = nums[0];
		vals[1] = nums[1];

		for (int i = 2; i < nums.length; i++) {
			int max1 = nums[i] + vals[i - 2];
			int max2 = i - 3 < 0 ? 0 : (nums[i] + vals[i - 3]);
			vals[i] = Math.max(max1, max2);
			max = Math.max(max, vals[i]);
		}
		return max;
	}
}
