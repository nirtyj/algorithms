package leetcode.easy;

import static org.junit.Assert.*;

import org.junit.Test;

public class LisenceKeyFormattingTest {

	@Test
	public void test() {
		assertEquals("2-5G-3J", LisenceKeyFormatting.licenseKeyFormatting("2-5g-3-J", 2));
	}

}
