package epi.strings;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntegerStringConversionsTest {

	@Test
	public void test() {
		assertEquals("123", IntegerStringConversions.convertIntegerToString(123));
		assertEquals("0", IntegerStringConversions.convertIntegerToString(0));
		assertEquals("-123456", IntegerStringConversions.convertIntegerToString(-123456));
	}
	
	@Test
	public void test2() {
		assertEquals(123, IntegerStringConversions.convertStringToInteger("123"));
		assertEquals(0, IntegerStringConversions.convertStringToInteger("0"));
		assertEquals(-123456, IntegerStringConversions.convertStringToInteger("-123456"));
	}

}
