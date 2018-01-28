package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class EncodeDecodeTinyURLTest {

	@Test
	public void test() {
		EncodeDecodeTinyURL encoder = new EncodeDecodeTinyURL();
		String shortUrl = encoder.encode("foobar");
		assertEquals("foobar", encoder.decode(shortUrl));
	}

}
