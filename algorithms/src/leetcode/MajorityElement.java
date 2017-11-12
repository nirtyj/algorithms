package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Linear Time Majority Vote Algorithm
 * 
 * @author njaganathan
 */
public class MajorityElement {

	public static int majorityElement(int[] nums) {

		int result = nums[0];
		int count = 0;

		for (int n : nums) {
			if (count == 0) {
				result = n;
				count++;
			} else if (result == n) {
				count++;
			} else {
				count--;
			}
		}
		return result;
	}

	public int majorityElement2(int[] num) {
		if (num.length == 1) {
			return num[0];
		}
		Arrays.sort(num);
		return num[num.length / 2];
	}

	/**
	 * Majority element is more than 1/3 of the size of the array. 2 possible
	 * majority elements.
	 * 
	 * @param nums
	 * @return
	 */
	public static List<Integer> majorityElementn3(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();

		Integer n1 = null, n2 = null;
		int c1 = 0, c2 = 0;

		for (int i : nums) {
			if (n1 != null && i == n1.intValue()) {
				c1++;
			} else if (n2 != null && i == n2.intValue()) {
				c2++;
			} else if (c1 == 0) {
				c1 = 1;
				n1 = i;
			} else if (c2 == 0) {
				c2 = 1;
				n2 = i;
			} else {
				c1--;
				c2--;
			}
		}

		c1 = c2 = 0;

		for (int i : nums) {
			if (i == n1.intValue()) {
				c1++;
			} else if (i == n2.intValue()) {
				c2++;
			}
		}

		if (c1 > nums.length / 3)
			result.add(n1);
		if (c2 > nums.length / 3)
			result.add(n2);

		return result;
	}

}
