package epi.dynamic_programming;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class MaxSubArraySumTest {

	@Test
	public void test() {
		Integer[] input = {-5, -4, -3, -2, -1};
		assertEquals(-1, MaxSubArraySum.getMaxSum(Arrays.asList(input)));
	}

	@Test
	public void test2() {
		Integer[] input = {40, 524, 12, -335, -385, -125, 904, 481, -31};
		assertEquals(1385, MaxSubArraySum.getMaxSum(Arrays.asList(input)));
	}

}
