package epi.strings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FirstNonRepititiveCharTest {

	@Test
	public void testNonRepititveChar() {
		assertEquals('h', FirstNonRepititiveChar.findFirstNonRepititiveChar("hello"));
	}

	@Test
	public void testNonRepititveChar2() {
		assertEquals('o', FirstNonRepititiveChar.findFirstNonRepititiveChar("jkiokji"));
	}

	@Test
	public void testNonRepititveChar3() {
		assertEquals('o', FirstNonRepititiveChar.findFirstNonRepititiveChar("hehlleo"));
	}
	
	@Test
	public void testNonRepititveChar4() {
		assertEquals('a', FirstNonRepititiveChar.findFirstNonRepititiveChar("asdfg"));
	}

	@Test
	public void testNonRepititveChar5() {
		assertEquals('a', FirstNonRepititiveChar.findFirstNonRepititiveChar("aabb"));
	}

}
