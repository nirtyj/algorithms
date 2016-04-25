package leetcode.dynamic_programming;

import static org.junit.Assert.*;

import org.junit.Test;

public class JumpGameTest {

	@Test
	public void test() {
		int arr[] = { 2, 3, 1, 1, 4 };
		assertEquals(true, JumpGame.canJump(arr));
	}

	@Test
	public void test2() {
		int arr[] = { 3, 2, 1, 0, 4 };
		assertEquals(false, JumpGame.canJump(arr));
	}

	@Test
	public void test3() {
		int arr[] = { 3, 0, 2, 0, 4 };
		assertEquals(true, JumpGame.canJump(arr));
	}

}
