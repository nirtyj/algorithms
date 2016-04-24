package leetcode.dynamic_programming;

import static org.junit.Assert.*;

import org.junit.Test;

import leetcode.dynamic_programming.DistinctSubsequence;

public class DistinctSubsequenceTest {

	@Test
	public void test() {
		assertEquals(3, DistinctSubsequence.numDistincts("rabbbit", "rabbit"));
	}

}
