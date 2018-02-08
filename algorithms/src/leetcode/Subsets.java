package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	/**
	 * Leetcode verified
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ps = new ArrayList<>();
		ps.add(new ArrayList<Integer>()); // add the empty set

		// for every item in the original list

		for (int i = 0; i < nums.length; i++) {
			Integer item = nums[i];
			List<List<Integer>> newPs = new ArrayList<List<Integer>>();

			for (List<Integer> subset : ps) {
				// copy all of the current powerset's subsets
				newPs.add(subset);

				// plus the subsets appended with the current item
				List<Integer> newSubset = new ArrayList<Integer>(subset);
				newSubset.add(item);
				newPs.add(newSubset);
			}

			// powerset is now powerset of list.subList(0, list.indexOf(item)+1)
			ps = newPs;
		}
		return ps;
	}
}
