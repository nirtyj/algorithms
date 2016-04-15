package epi.searching;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class FindMaxAndMinTest {

	@Test
	public void test() {
		Integer[] input = {-14, -10, 2, 108, 108, 243, 285, 285, 285, 401};
		assertEquals(-14, FindMaxAndMin.findMinMax(Arrays.asList(input)).min);
		assertEquals(401, FindMaxAndMin.findMinMax(Arrays.asList(input)).max);
	}
	
	@Test
	public void test2() {
		Integer[] input = {-14, -10, 2, 108, 108, 243, 285, 285, 285, 401, -90};
		assertEquals(-90, FindMaxAndMin.findMinMax(Arrays.asList(input)).min);
		assertEquals(401, FindMaxAndMin.findMinMax(Arrays.asList(input)).max);
	}

}
