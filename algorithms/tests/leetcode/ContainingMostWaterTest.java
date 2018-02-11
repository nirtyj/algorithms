package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import leetcode.medium.ContainerWithMostWater;

public class ContainingMostWaterTest {

	
	@Test
	public void test() {
		int[] A = { 1, 2, 1, 3, 4, 4, 5, 6, 2, 1, 3, 1, 3, 2, 1, 2, 4, 1 };
		assertEquals(48, ContainerWithMostWater.maxArea(A));
	}

}
