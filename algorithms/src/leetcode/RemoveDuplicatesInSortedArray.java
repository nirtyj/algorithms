package leetcode;

public class RemoveDuplicatesInSortedArray {

	/**
	 * Leetcode verified
	 * 
	 * @param nums
	 * @return
	 */
	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 1)
			return 1;

		int i = 0;
		int currIndex = 0;
		while (i < nums.length) {
			nums[currIndex] = nums[i];
			while (i < nums.length && nums[currIndex] == nums[i])
				i++;

			currIndex++;
		}
		return currIndex;
	}
}
