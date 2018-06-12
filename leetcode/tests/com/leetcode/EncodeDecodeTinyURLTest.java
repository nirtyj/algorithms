package com.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leetcode.medium.EncodeDecodeTinyURL_535;

public class EncodeDecodeTinyURLTest {

	@Test
	public void test() {
		EncodeDecodeTinyURL_535 encoder = new EncodeDecodeTinyURL_535();
		String shortUrl = encoder.encode("foobar");
		assertEquals("foobar", encoder.decode(shortUrl));
	}

}
