package leetcode.dynamic_programming;

import static org.junit.Assert.*;

import org.junit.Test;

import dynamic_programming.JumpGame3;

public class JumpGame3Test {

	@Test
	public void test() {
		int s = 4, m = 2;
		assertEquals(5, JumpGame3.countWaysDp(s, m));
	}
	
	@Test
	public void test2() {
		int s = 4, m = 2;
		assertEquals(5, JumpGame3.countWaysRecursion(s, m));
	}

}
