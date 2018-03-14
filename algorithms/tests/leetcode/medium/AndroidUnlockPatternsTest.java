package leetcode.medium;

import static org.junit.Assert.*;

import org.junit.Test;

public class AndroidUnlockPatternsTest {

	@Test
	public void test() {
		//assertEquals(9, AndroidUnlockPatterns.numberOfPatterns(1, 1));
		//assertEquals(65, AndroidUnlockPatterns.numberOfPatterns(1, 2));
		assertEquals(2009, AndroidUnlockPatterns.numberOfPatterns(1, 4));
	}

}
