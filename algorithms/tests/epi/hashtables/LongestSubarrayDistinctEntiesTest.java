package epi.hashtables;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class LongestSubarrayDistinctEntiesTest {

	@Test
	public void test() {
		Character[] entries = { 'f', 's', 'f', 'e', 't', 'w', 'e', 'n', 'w', 'e' };
		assertEquals(5, LongestSubarrayDistinctEnties.findLongestSubarrayDistinctEnties(Arrays.asList(entries)));
	}

}
