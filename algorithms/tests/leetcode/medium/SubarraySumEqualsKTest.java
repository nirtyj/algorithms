package leetcode.medium;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubarraySumEqualsKTest {

	@Test
	public void test() {
		int[] nums = { 1,2,1,2,1};
		assertEquals(4, SubarraySumEqualsK.subarraySum(nums, 3));
	}

}
