package epi.recursion;

import static org.junit.Assert.*;

import org.junit.Test;

public class TowerOfHanoiTest {

	@Test
	public void test() {
		assertEquals(15, TowerOfHanoi.computeTowerHanoi(4));
	/*	assertEquals(1, TowerOfHanoi.computeTowerHanoi(1));
		assertEquals(0, TowerOfHanoi.computeTowerHanoi(0));
		assertEquals(1023, TowerOfHanoi.computeTowerHanoi(10));*/
	}

}
