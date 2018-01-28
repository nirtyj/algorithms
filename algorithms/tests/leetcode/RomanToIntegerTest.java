package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class RomanToIntegerTest {

	@Test
	public void test() {
		assertEquals(3787, RomanToInteger.romanToInt("MMMDCCLXXXvII"));
		assertEquals(374, RomanToInteger.romanToInt("CCCLXXIV"));
		assertEquals(44, RomanToInteger.romanToInt("XLIV"));
	}

}
