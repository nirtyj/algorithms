package com.leetcode;

import com.leetcode.hard.WordLadderII;
import com.leetcode.utils.LeetcodeUtils;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class WordLadderIIRecursionTest {

    @Test
    public void test() {
        String[] dictArr = {"hot", "dog", "dot"};
        List<String> dict = LeetcodeUtils.arrayToList(dictArr);
        assertEquals(1, WordLadderII.findLadders("hot", "dog", dict).size());
    }

    @Test
    public void test2() {
        String[] dictArr = {"si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av",
                "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe",
                "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if",
                "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi",
                "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt",
                "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye"};

        List<String> dict = LeetcodeUtils.arrayToList(dictArr);
        assertEquals(51, WordLadderII.findLadders("qa", "sq", dict).size());
    }
}
