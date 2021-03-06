package com.leetcode;

import com.leetcode.easy.ReverseInteger;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseIntegerTest {

    @Test
    public void test() {
        assertEquals(131, ReverseInteger.reverse(131));
        assertEquals(5441, ReverseInteger.reverse(1445));
        assertEquals(1441, ReverseInteger.reverse(1441));
        assertEquals(-5441, ReverseInteger.reverse(-1445));
        assertEquals(-9999, ReverseInteger.reverse(-9999));
    }

}
