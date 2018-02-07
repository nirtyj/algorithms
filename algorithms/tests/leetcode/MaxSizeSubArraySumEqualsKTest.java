package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxSizeSubArraySumEqualsKTest {

	@Test
	public void test() {
		MaxSizeSubArraySumEqualsK m = new MaxSizeSubArraySumEqualsK();
		int[] nums = {1, -1, 5, -2, 3};
		assertEquals(4, m.maxSubArrayLen(nums, 3));
	}

}
