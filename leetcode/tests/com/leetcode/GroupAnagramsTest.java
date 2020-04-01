package com.leetcode;

import com.leetcode.medium.GroupAnagrams_49;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class GroupAnagramsTest {

    @Test
    public void test() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = GroupAnagrams_49.groupAnagrams(input);
        assertEquals(3, result.size());
    }

}
