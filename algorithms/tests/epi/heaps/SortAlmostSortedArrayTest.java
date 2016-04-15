package epi.heaps;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SortAlmostSortedArrayTest {

	@Test
	public void test() {
		Integer[] arr1 = {3, -1, 2, 6, 4, 5, 8};		
		SortAlmostSortedArray.sortAlmost(Arrays.asList(arr1), 2);
		Integer[] resultArray = {-1, 2, 3, 4, 5, 6, 8};
		assertEquals(Arrays.asList(resultArray), Arrays.asList(arr1));
	}

}
