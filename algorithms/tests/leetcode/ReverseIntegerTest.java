package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseIntegerTest {

	@Test
	public void test() {
		assertEquals(131 , ReverseInteger.reversDigits(131));
		assertEquals(5441 , ReverseInteger.reversDigits(1445));
		assertEquals(1441 , ReverseInteger.reversDigits(1441));
		assertEquals(-5441 , ReverseInteger.reversDigits(-1445));
		assertEquals(-9999 , ReverseInteger.reversDigits(-9999));
	}

}
