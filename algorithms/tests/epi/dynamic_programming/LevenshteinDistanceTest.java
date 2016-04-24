package epi.dynamic_programming;

import static org.junit.Assert.*;

import org.junit.Test;

public class LevenshteinDistanceTest {

	@Test
	public void test() {
		assertEquals(8, LevenshteinDistance.minDistance("carthorse",	"Orchestra"));
		assertEquals(3, LevenshteinDistance.minDistance("kitten",	"sitting"));
		assertEquals(1, LevenshteinDistance.minDistance("geek",	"gesek"));
		assertEquals(3, LevenshteinDistance.minDistance("kitten",	"sitting"));
	}

}
