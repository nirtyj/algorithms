package leetcode.medium;

/**
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
*/
public class RemoveDuplicatesFromSortedArrayII {

	public static int removeDuplicates(int[] nums) {
		int i = 0;
		for (int n : nums)
		{
			// for starting 0, 1 - let it pass through
			// if current number is greater than previous, copy
			if (i < 2 || n > nums[i - 2])
			{
				nums[i] = n;
				i++;
			}
		}
		return i;
	}
}
