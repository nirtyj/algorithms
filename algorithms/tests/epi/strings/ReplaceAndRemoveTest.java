package epi.strings;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class ReplaceAndRemoveTest {

	@Test
	public void testReplaceAndRemove() {
		char[] input = { 'a', 'b', 'c', 'a', 'g', 'b', 'a', '0', };
		ReplaceAndRemove.replaceAndRemove(7, input);
		assertTrue(Arrays.equals("ddcddgdd".toCharArray(), input));
	}

	@Test
	public void testReplaceAndRemove2() {
		char[] input = { 'a', 'b', 'b', 'b', 'g', 'a' };
		ReplaceAndRemove.replaceAndRemove(6, input);
		assertTrue(Arrays.equals("ddgdda".toCharArray(), input));
	}

}
