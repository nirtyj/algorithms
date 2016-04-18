package epi.stacks_queues;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StackWithMaxImprovedTest {

	@Test
	public void test() {
		StackWithMaxImproved s = new StackWithMaxImproved();
	    s.push(1);
	    s.push(2);
	    assertTrue(s.max() == 2);
	    s.push(2);
	    assertTrue(s.max() == 2);
		s.push(3);
		assertTrue(s.max() == 3);
		s.push(1);
		s.push(2);
		assertTrue(s.max() == 3);
		s.pop();
		assertTrue(s.max() == 3);
		s.pop();
		assertTrue(s.max() == 3);
		s.pop();
		assertTrue(s.max() == 2);
		s.pop();
		assertTrue(s.max() == 2);
		s.pop();
		assertTrue(s.max() == 1);
		s.pop();
	}

}
