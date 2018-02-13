package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
*/
public class MissingRanges {

	/**
	 * Leetcode verified
	 * @param nums
	 * @param lower
	 * @param upper
	 * @return
	 */
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		if (nums == null)
			return Collections.emptyList();

		List<String> result = new ArrayList<>();
		// empty input case
		if (nums.length == 0) {
			getRange(result, lower, upper);
			return result;
		}

		// for lower range
		if (nums[0] > lower) {
			int min = lower;
			int max = nums[0] - 1;
			getRange(result, min, max);
		}

		// for whats provided in the input
		int low = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > low) {
				int min = low + 1;
				int max = nums[i] - 1;
				getRange(result, min, max);
			}
			low = nums[i];
		}

		// for upper range
		if (nums[nums.length - 1] < upper) {
			int min = nums[nums.length - 1] + 1;
			int max = upper;
			getRange(result, min, max);
		}
		return result;
	}

	private void getRange(List<String> result, int min, int max) {
		if (min == max)
			result.add(Integer.toString(min));
		else if (min < max)
			result.add(Integer.toString(min) + "->" + Integer.toString(max));
		// ignore if max > min
	}

}
