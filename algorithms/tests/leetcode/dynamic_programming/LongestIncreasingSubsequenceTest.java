package leetcode.dynamic_programming;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestIncreasingSubsequenceTest {

	@Test
	public void test() {
		int[] input = {10, 9, 2, 5, 3, 7, 101, 18};
		assertEquals(4, LongestIncreasingSubsequence.lengthOfLISRecusion(input));
	}
	
	@Test
	public void test1() {
		int[] input = {10, 2, 5};
		assertEquals(2, LongestIncreasingSubsequence.lengthOfLISRecusion(input));
	}
	
	@Test
	public void test2() {
		int[] input = {2, 5};
		assertEquals(2, LongestIncreasingSubsequence.lengthOfLISRecusion(input));
	}

	@Test
	public void test3() {
		int[] input = {10, 9, 2, 5, 3, 7, 101, 18};
		assertEquals(4, LongestIncreasingSubsequence.lengthOfLISDp(input));
	}
	
	@Test
	public void test4() {
		int[] input = {10, 2, 5};
		assertEquals(2, LongestIncreasingSubsequence.lengthOfLISDp(input));
	}
	
	@Test
	public void test5() {
		int[] input = {2, 5};
		assertEquals(2, LongestIncreasingSubsequence.lengthOfLISDp(input));
	}

}
