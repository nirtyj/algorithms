package com.leetcode;

import com.leetcode.easy.ValidWordSquare;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class ValidWordSquareTest {

    @Test
    public void test() {
        String[] arr = {"abcd", "bnrt", "crm", "dt"};
        assertTrue(ValidWordSquare.validWordSquare(Arrays.asList(arr)));
    }

}
