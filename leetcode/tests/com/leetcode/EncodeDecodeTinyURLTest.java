package com.leetcode;

import com.leetcode.medium.EncodeDecodeTinyURL_535;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EncodeDecodeTinyURLTest {

    @Test
    public void test() {
        EncodeDecodeTinyURL_535 encoder = new EncodeDecodeTinyURL_535();
        String shortUrl = encoder.encode("foobar");
        assertEquals("foobar", encoder.decode(shortUrl));
    }

}
