package leetcode.dynamic_programming;

public class MaxProductSubarray {

	public static int maxProduct(int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;

		int max = nums[0];
		int min = nums[0];
		int result = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int prev_max = max;
			int prev_min = min;
			
			/**
			 * Maximum of 
			 * 		nums[i] (may be +ve or -ve) / 
			 * 		max of prev (+ve) max vs nums[i] (+ve) /
			 * 		max of prev (-ve) min * nums[i] (-ve) 
			 */
			max = Math.max(nums[i], Math.max(prev_max * nums[i], prev_min * nums[i]));
			
			/**
			 * minimum of 
			 * 		nums[i] (may be +ve or -ve) / 
			 * 		min of prev (+ve) max * nums[i] (-ve) / 
			 * 		prev_min (-ve) * nums[i] (+ve)
			 */
			min = Math.min(nums[i], Math.min(prev_max * nums[i], prev_min * nums[i]));
			result = Math.max(result, max);
			
			System.out.println("val - " + nums[i]);
			System.out.println("max - " + max);
			System.out.println("min - " + min);
		}

		return result;
	}
}