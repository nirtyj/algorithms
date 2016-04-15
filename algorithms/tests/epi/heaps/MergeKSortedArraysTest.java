package epi.heaps;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import epi.searching.Search2DSortedArrayTest;

public class MergeKSortedArraysTest {

	@Test
	public void test() {
		List<List<Integer>> matrix = Search2DSortedArrayTest.getMatrix();		
		List<Integer> result = MergeKSortedArrays.mergeKArrays(matrix);		
		Integer[] expected = {-1, 1, 2, 3, 3, 4, 4, 5, 5, 6, 6, 6, 6, 6, 8, 8, 8, 9, 9, 9, 10, 10, 12, 12, 13, 21, 22, 24, 25, 40};
		assertEquals(Arrays.asList(expected), result); 
	}

}
