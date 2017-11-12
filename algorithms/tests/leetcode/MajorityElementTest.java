package leetcode;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class MajorityElementTest {

	@Test
	public void test() {
		int[] input = {2, 2};
		List<Integer> results = MajorityElement.majorityElementn3(input);
		assertEquals(2, results.get(0).intValue());
	}

	@Test
	public void test2() {
		int[] input = {1, 2};
		List<Integer> results = MajorityElement.majorityElementn3(input);
		assertEquals(1, results.get(0).intValue());
		assertEquals(2, results.get(1).intValue());
	}
}
