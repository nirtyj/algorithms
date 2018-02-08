package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class BadVersionTest {

	@Test
	public void test() {
		BadVersion v = new BadVersion(3);
		assertEquals(3, v.firstBadVersion(3));
	}

}
