package epi.strings;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LookAndSayTest {

	@Test
	public void testLookAndSay1() {
		assertTrue(LookAndSayORCountAndSay.lookAndSay(1).equals("1"));
		assertTrue(LookAndSayORCountAndSay.lookAndSay(2).equals("11"));
		assertTrue(LookAndSayORCountAndSay.lookAndSay(3).equals("21"));
		assertTrue(LookAndSayORCountAndSay.lookAndSay(4).equals("1211"));
		assertTrue(LookAndSayORCountAndSay.lookAndSay(5).equals("111221"));
		assertTrue(LookAndSayORCountAndSay.lookAndSay(6).equals("312211"));
		assertTrue(LookAndSayORCountAndSay.lookAndSay(7).equals("13112221"));
		assertTrue(LookAndSayORCountAndSay.lookAndSay(8).equals("1113213211"));
	}
	

}
