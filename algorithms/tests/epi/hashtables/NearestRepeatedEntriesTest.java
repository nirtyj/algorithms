package epi.hashtables;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class NearestRepeatedEntriesTest {

	@Test
	public void test() {
		String paragraph = "All work and no play makes for no work no fun and no results";
		assertEquals(2, NearestRepeatedEntries.findNearestRepeatedEntries(Arrays.asList(paragraph.split(" "))));		
	}

}
