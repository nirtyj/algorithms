package com.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leetcode.medium.EncodeDecodeTinyURL;

public class EncodeDecodeTinyURLTest {

	@Test
	public void test() {
		EncodeDecodeTinyURL encoder = new EncodeDecodeTinyURL();
		String shortUrl = encoder.encode("foobar");
		assertEquals("foobar", encoder.decode(shortUrl));
	}

}
