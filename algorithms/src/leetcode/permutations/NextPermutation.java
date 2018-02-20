package leetcode.permutations;

/**
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

*/
public class NextPermutation {

	/**
	 * Leetcode verified
	 * https://leetcode.com/media/original_images/31_Next_Permutation.gif
	 * @param nums
	 */
	public static void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 1)
			return;

		int i = nums.length - 2;
		// find the number that is first decreasing
		while (i >= 0 && nums[i + 1] <= nums[i]) {
			i--;
		}
		if (i >= 0) {
			int j = nums.length - 1;
			// find the next high number to the number that is first decreasing
			while (j >= 0 && nums[j] <= nums[i]) {
				j--;
			}
			//swap both
			swap(nums, i, j);
		}
		//reverse the rest of elements to the right
		reverse(nums, i + 1, nums.length - 1);
	}

	public static void reverse(int[] arr, int m, int n) {
		while (m <= n) {
			swap(arr, m, n);
			m++;
			n--;
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
