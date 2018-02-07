package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class DecodeWaysTest {

	@Test
	public void test() {
		DecodeWays ways = new DecodeWays();
		assertEquals(2, ways.numDecodings("11"));
	}

}
