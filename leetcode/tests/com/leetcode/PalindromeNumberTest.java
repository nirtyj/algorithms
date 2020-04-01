package com.leetcode;

import com.leetcode.easy.PalindromeNumber;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PalindromeNumberTest {

    @Test
    public void test() {
        assertEquals(true, PalindromeNumber.isPalindrome(131));
        assertEquals(false, PalindromeNumber.isPalindrome(1445));
        assertEquals(true, PalindromeNumber.isPalindrome(1441));
    }

}
