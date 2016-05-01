package puzzles;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class MediansTest {

	@Test
	public void test1() {
		Integer[] arr1 = { 9, 28, 1, 12, 5, 26, 7, 14, 3, 7, 2 };
		assertEquals( 7, Medians.findMedian(Arrays.asList(arr1)));
	}

}
