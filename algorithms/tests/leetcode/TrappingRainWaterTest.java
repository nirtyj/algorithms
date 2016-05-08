package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrappingRainWaterTest {

	@Test
	public void test() {
		int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
		assertEquals(6, TrappingRainWater.trap(input));
	}

}
