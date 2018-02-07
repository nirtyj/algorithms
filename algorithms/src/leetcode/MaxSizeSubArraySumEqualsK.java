package leetcode;

import java.util.HashMap;

/**
 * Leetcode verified
 * @author njaganathan
 *
 */
public class MaxSizeSubArraySumEqualsK {

	public int maxSubArrayLen(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = 0;

		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			// calculate sum
			sum += nums[i];

			// if sum is k, update max
			if (sum == k) {
				max = Math.max(max, i + 1);
			}

			int diff = sum - k;

			if (map.containsKey(diff)) {
				// if there is an entry for diff, means that there is a subarray that has summed up to k - > map.get(diff)
				// so, from that index until current index (i - map.get(diff)) is a subarray sum that would match k.
				// compare and set the max.
				max = Math.max(max, i - map.get(diff));
			}
			// set the sum and its index
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}

		return max;
	}
}
