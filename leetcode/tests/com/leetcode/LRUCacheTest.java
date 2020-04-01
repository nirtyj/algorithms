package com.leetcode;

import com.leetcode.hard.LRUCache;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LRUCacheTest {

    @Test
    public void test() {
        LRUCache cache = new LRUCache(1);
        cache.set(2, 1);
        assertEquals(1, cache.get(2));
        cache.set(3, 2);
        assertEquals(-1, cache.get(2));
        assertEquals(2, cache.get(3));
    }

}
