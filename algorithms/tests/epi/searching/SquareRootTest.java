package epi.searching;

import static org.junit.Assert.*;

import org.junit.Test;

public class SquareRootTest {

	@Test
	public void test() {
		assertEquals(4, SquareRoot.findSquareRoot(16));
		assertEquals(17, SquareRoot.findSquareRoot(300));
		assertEquals(4, SquareRoot.findSquareRoot(17));
		assertEquals(4, SquareRoot.findSquareRoot(19));
		assertEquals(46339, SquareRoot.findSquareRoot(2147395599));
	}

}
