package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
/**
Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.

Note:
The array size can be very large. Solution that uses too much extra space will not pass the judge.

Example:

int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);

// pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(3);

// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
solution.pick(1);
*/
public class RandomPickIndex {

	/**
	 * Leetcode verified
	 */
	HashMap<Integer, List<Integer>> map = new HashMap<>();
	Random rand = new Random();
	public RandomPickIndex(int[] nums) {
        for(int i=0; i< nums.length; i++)
        {
            int num = nums[i];
            List<Integer> list = map.getOrDefault(num, new ArrayList<>());
            list.add(i);
            map.put(num, list);
        }
    }

	public int pick(int target) {
		if (map.containsKey(target)) {
			List<Integer> list = map.get(target);
			int randomIndex = rand.nextInt(list.size());
			return list.get(randomIndex);
		} else {
			return -1;
		}
	}
}
