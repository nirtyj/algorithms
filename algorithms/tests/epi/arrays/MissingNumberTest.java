package epi.arrays;

import static org.junit.Assert.*;

import org.junit.Test;

public class MissingNumberTest {

	@Test
	public void test() {
		int[] a = {1, 3, 4, 5};
		assertEquals(2, MissingNumber.getMissingNo(a, 5));
	}
	@Test
	public void test2() {
		int a[] = {1, 2, 4, 5, 6};
		assertEquals(3, MissingNumber.getMissingNo(a, 6));
	}
	
	@Test
	public void test3() {
		int[] a = {1, 3, 4, 5};
		assertEquals(2, MissingNumber.getMissingNoXor(a, 5));
	}
	@Test
	public void test4() {
		int a[] = {1, 2, 4, 5, 6};
		assertEquals(3, MissingNumber.getMissingNoXor(a, 6));
	}
	
}
