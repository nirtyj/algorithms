package com.leetcode;

import com.leetcode.easy.LisenceKeyFormatting;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LisenceKeyFormattingTest {

    @Test
    public void test() {
        assertEquals("2-5G-3J", LisenceKeyFormatting.licenseKeyFormatting("2-5g-3-J", 2));
    }

}
