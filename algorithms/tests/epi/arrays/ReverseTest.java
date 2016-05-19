package epi.arrays;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ReverseTest {

	@Test
	public void test() {
		int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 8, 10};
		int b[] = {10, 8, 8, 7, 6, 5, 4, 3, 2, 1 }; 
		Reverse.rvereseArray(a);
		assertTrue(Arrays.equals(b, a));
	}

}
