package epi.recursion;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SubsetSizeKTest {

	@Test
	public void test() {
		List<List<Integer>> result = SubsetSizeK.combinations(4, 2);
		List<List<Integer>> goldenResult = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(1, 3), Arrays.asList(1, 4),
				Arrays.asList(2, 3), Arrays.asList(2, 4), Arrays.asList(3, 4));
		assertTrue(result.equals(goldenResult));
	}

	@Test
	public void test2() {
		List<List<Integer>> result = SubsetSizeK.combinations(5, 2);
		List<List<Integer>> goldenResult = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(1, 3), Arrays.asList(1, 4),
				Arrays.asList(1, 5), Arrays.asList(2, 3), Arrays.asList(2, 4), Arrays.asList(2, 5), Arrays.asList(3, 4),
				Arrays.asList(3, 5), Arrays.asList(4, 5));
		assertTrue(result.equals(goldenResult));
	}
}
