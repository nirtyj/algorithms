package leetcode.easy;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class ValidWordSquareTest {

	@Test
	public void test() {
		String[] arr = {"abcd","bnrt","crm","dt"};
		assertTrue(ValidWordSquare.validWordSquare(Arrays.asList(arr)));
	}

}
