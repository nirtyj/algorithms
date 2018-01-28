package leetcode;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class MoveZerosTest {

	@Test
	public void test() {
		int[] arr = {0,1,0,3,12};
		MoveZeros.moveZeroes(arr);
		assertEquals("[1, 3, 12, 0, 0]",Arrays.toString(arr));
	}

}
