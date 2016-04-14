package epi.searching;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class FirstOccuranceInSortedArrayTest {

	@Test
	public void test() {
		Integer[] input = {-14, -10, 2, 108, 108, 243, 285, 285, 285, 401};
		assertEquals(3, FirstOccuranceInSortedArray.findFirstOccuranceofK(Arrays.asList(input), 108));
	}
	
	@Test
	public void test2() {
		Integer[] input = {-14, -10, 2, 108, 108, 243, 285, 285, 285, 401};
		assertEquals(6, FirstOccuranceInSortedArray.findFirstOccuranceofK(Arrays.asList(input), 285));
	}
	
	@Test
	public void test3() {
		Integer[] input = {-14,-14, -10, 2, 108, 108, 243, 285, 285, 285, 401};
		assertEquals(0, FirstOccuranceInSortedArray.findFirstOccuranceofK(Arrays.asList(input), -14));
	}

}
