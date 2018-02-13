package leetcode.easy;

import static org.junit.Assert.*;

import org.junit.Test;

public class HouseRobberTest {

	@Test
	public void test() {
		int[] arr = {2,7,9,3,1};
		assertEquals(12, HouseRobber.rob(arr));
	}

}
