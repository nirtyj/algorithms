package epi.searching;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Search2DSortedArrayTest {

	private List<List<Integer>> getMatrix() {
		Integer[] r0 = {-1, 2, 4, 4, 6};
		Integer[] r1 = {1, 5, 5, 9, 21};
		Integer[] r2 = {3, 6, 6, 9, 22};
		Integer[] r3 = {3, 6, 8, 10, 24};
		Integer[] r4 = {6, 8, 9, 12, 25};
		Integer[] r5 = {8, 10, 12, 13, 40};
		List<List<Integer>> matrix = new ArrayList<>();
		matrix.add(Arrays.asList(r0));
		matrix.add(Arrays.asList(r1));
		matrix.add(Arrays.asList(r2));
		matrix.add(Arrays.asList(r3));
		matrix.add(Arrays.asList(r4));
		matrix.add(Arrays.asList(r5));
		return matrix;
	}
	
	@Test
	public void test() {
		List<List<Integer>> matrix = getMatrix();
		assertEquals(true, Search2DSortedArray.findElement(matrix, 40));
	}
	

	@Test
	public void test1() {
		List<List<Integer>> matrix = getMatrix();
		assertEquals(false, Search2DSortedArray.findElement(matrix, 90));
	}

	@Test
	public void test2() {
		List<List<Integer>> matrix = getMatrix();
		assertEquals(true, Search2DSortedArray.findElement(matrix, -1));
	}
	
	@Test
	public void test3() {
		List<List<Integer>> matrix = getMatrix();
		assertEquals(true, Search2DSortedArray.findElement(matrix, 8));
	}
	

}
