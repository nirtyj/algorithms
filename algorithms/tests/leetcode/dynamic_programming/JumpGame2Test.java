package leetcode.dynamic_programming;

import static org.junit.Assert.*;

import org.junit.Test;

import com.leetcode.hard.JumpGame2;

public class JumpGame2Test {

	@Test
	public void test() {
		int arr[] = { 2, 3, 1, 1, 4 };
		assertEquals(2, JumpGame2.minJump(arr));
	}
	

	@Test
	public void test2() {
		int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		assertEquals(3, JumpGame2.minJump(arr));
	}

	@Test
	public void test3() {
		int arr[] = { 6, 3, 1, 1, 4 };
		assertEquals(1, JumpGame2.minJump(arr));
	}
	

	@Test
	public void test4() {
		int arr[] = { 6,1 };
		assertEquals(1, JumpGame2.minJump(arr));
	}
	
	@Test
	public void test5() {
		int arr[] = { 3, 2, 1, 0, 4 };
		assertEquals(0, JumpGame2.minJump(arr));
	}
	

}
