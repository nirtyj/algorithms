package leetcode.medium;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContinuousSubarraySumTest {

	@Test
	public void test() {
		int nums[] = { 0, 1, 0 };
		assertFalse(ContinuousSubarraySum.checkSubarraySum(nums, 0));
	}

}
