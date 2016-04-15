package epi.searching;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class DuplicateAndMissingTest {

	@Test
	public void test() {
		Integer[] input = {1, 2, 4, 5, 6};
		assertEquals(3, DuplicateAndMissing.findMissingElement(Arrays.asList(input)));

	}

}
