package com.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddBoldTagTest {

    @Test
    public void test() {
        AddBoldTag_616 b = new AddBoldTag_616();
        String[] dict = {"abc", "123"};
        assertEquals("<b>abc</b>xyz<b>123</b>", b.addBoldTag("abcxyz123", dict));
    }

    @Test
    public void test2() {
        AddBoldTag_616 b = new AddBoldTag_616();
        String[] dict = {"aaa", "aab", "bc"};
        assertEquals("<b>aaabbc</b>c", b.addBoldTag("aaabbcc", dict));
    }

}
