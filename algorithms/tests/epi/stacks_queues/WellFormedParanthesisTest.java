package epi.stacks_queues;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WellFormedParanthesisTest {

	@Test
	public void test() {
		assertTrue(WellFormedParanthesis.isWellFormed("()"));
		assertTrue(WellFormedParanthesis.isWellFormed("()[]{}"));
		assertTrue(WellFormedParanthesis.isWellFormed("[()[]]{}"));
		assertTrue(WellFormedParanthesis.isWellFormed("(()[]{()[]{}{}})"));
		assertTrue(!WellFormedParanthesis.isWellFormed("([)]"));
		assertTrue(!WellFormedParanthesis.isWellFormed("["));
		assertTrue(!WellFormedParanthesis.isWellFormed("(()[]{()[]{})({}})"));
	}

}
