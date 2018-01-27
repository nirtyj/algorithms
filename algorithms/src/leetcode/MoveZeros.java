package leetcode;

public class MoveZeros {

	/**
	 * Leetcode verified
	 * @param nums
	 */
	public static void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1)
			return;

		int count = 0;
		int currIndex = 0;
		int nextIndex = 0;
		while (nextIndex < nums.length) {
			while (nextIndex < nums.length && nums[nextIndex] == 0) {
				count++;
				nextIndex++;
			}
			if (nextIndex >= nums.length)
				break;
			nums[currIndex] = nums[nextIndex];
			currIndex++;
			nextIndex++;
		}

		for (int i = nums.length - 1; count > 0; i--) {
			nums[i] = 0;
			count--;
		}
	}
}
