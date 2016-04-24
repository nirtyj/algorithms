package epi.recursion;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class PermutationsTest {

	private static void smallTest() {
		List<Integer> A = Arrays.asList(0, 1, 2);
		List<List<Integer>> result = Permutations.permutations(A);
		assertEquals(6,result.size());
		List<List<Integer>> goldenResult = Arrays.asList(Arrays.asList(0, 1, 2), Arrays.asList(0, 2, 1),
				Arrays.asList(1, 0, 2), Arrays.asList(1, 2, 0), Arrays.asList(2, 1, 0), Arrays.asList(2, 0, 1));
		assertTrue(result.equals(goldenResult));
	}

	@Test
	public void test() {
		smallTest();
		Random r = new Random();
		int n = r.nextInt(8) + 1;
		
		List<Integer> A = new ArrayList<>(n);
		int val = 0;
		for (int i = 0; i < n; i++) {
			A.add(val++);
		}
		List<List<Integer>> result = Permutations.permutations(A);
		System.out.println("n = " + n);
		for (List<Integer> vec : result) {
			System.out.println(vec);
		}
	}
	
	@Test
	public void testPermString() {
		List<String> result = Permutations.permString("1234");
		assertEquals(24, result.size());
		System.out.println(Arrays.toString(result.toArray()));
	}
	
	@Test
	public void testPermuationsIterative()
	{
		List<Integer> A = Arrays.asList(0, 1, 2);
		List<ArrayList<Integer>> result = Permutations.permutationsIterative(A);
		assertEquals(6,result.size());
		List<List<Integer>> goldenResult = Arrays.asList(Arrays.asList(2, 1, 0), Arrays.asList(1, 2, 0),Arrays.asList(1, 0, 2), Arrays.asList(2, 0, 1), 
				Arrays.asList(0, 2, 1),
				Arrays.asList(0, 1, 2));
		assertTrue(result.equals(goldenResult));
	}
}
