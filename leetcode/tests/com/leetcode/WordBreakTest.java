package com.leetcode;

import com.leetcode.dp.WordBreak_LC139;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WordBreakTest {

    @Test
    public void test() {
        List<String> dict = new ArrayList<String>();
        dict.add("leet");
        dict.add("code");
        assertEquals(true, WordBreak_LC139.wordBreak("leetcode", dict));
    }

}
