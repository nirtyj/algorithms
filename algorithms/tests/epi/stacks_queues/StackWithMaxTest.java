package epi.stacks_queues;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StackWithMaxTest {

	@Test
	public void testStackWithMax()
	{
		StackWithMax s = new StackWithMax();
	    s.push(1);
	    s.push(2);
	    assertTrue(s.max() == 2);
	    System.out.println(s.max()); // 2
	    System.out.println(s.pop()); // 2
	    assertTrue(s.max() == 1);
	    System.out.println(s.max()); // 1
	    s.push(3);
	    s.push(2);
	    assertTrue(s.max() == 3);
	    System.out.println(s.max()); // 3
	    s.pop();
	    assertTrue(s.max() == 3);
	    System.out.println(s.max()); // 3
	    s.pop();
	    assertTrue(s.max() == 1);
	    System.out.println(s.max()); // 1
	    s.pop();
	}
	
	@Test
	public void testStackWithMax2()
	{
		StackWithMax s = new StackWithMax();
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
