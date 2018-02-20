package leetcode.permutations;

import java.util.ArrayList;
import java.util.List;

/**
Given a collection of distinct numbers, return all possible permutations.	
For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/
public class Permutations {

	/**
	 * Leetcode verified
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		if (nums.length == 0)
			return list;
		List<Integer> intList = new ArrayList<Integer>();
		for (int index = 0; index < nums.length; index++) {
			intList.add(nums[index]);
		}
		permuteAll(intList, list, new ArrayList<Integer>());
		return list;
	}

	private void permuteAll(List<Integer> init, List<List<Integer>> list, List<Integer> curr) {
		if (init.size() == 0) {
			list.add(new ArrayList<>(curr));
			return;
		}
		for (int i = 0; i < init.size(); i++) {
			
			// add it to the current and remove from init
			Integer val = init.get(i);
			curr.add(val);
			init.remove(i);
			permuteAll(init, list, curr);
			
			// remove the last added current & put it back to the init at the same position
			curr.remove(curr.size() - 1);
			init.add(i, val);
		}
	}
}
