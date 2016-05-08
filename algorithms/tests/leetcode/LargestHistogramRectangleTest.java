package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class LargestHistogramRectangleTest {

	@Test
	public void test() {
		int[] input = {2,1,5,6,2,3};
		assertEquals(10, LargestHistogramRectangle.largestRectangleArea(input));
	}

}
