package com.leetcode.hard;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 */
public class LFUCache {

    HashMap<Integer, Integer> vals; // holds actual value
    HashMap<Integer, Integer> counts; // for frequency
    HashMap<Integer, LinkedHashSet<Integer>> lists; // frequency -> key1, key2..
    int cap;
    int min = 0;

    public LFUCache(int capacity) {
        cap = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if (!vals.containsKey(key))
            return -1;
        // increase the counter,
        int count = counts.get(key);
        counts.put(key, count + 1);

        // remove the key from previous lists
        lists.get(count).remove(key);
        // update the new key to lists
        if (!lists.containsKey(count + 1))
            lists.put(count + 1, new LinkedHashSet<>());
        lists.get(count + 1).add(key);

        // update the minimum
        if (count == min && lists.get(count).size() == 0)
            min++;

        return vals.get(key);
    }

    public void put(int key, int value) {
        if (cap <= 0)
            return;
        // if it contains, just increase the access count. after updating the value
        if (vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        }
        // if its a new value, check if it exceeds the capacity. if yes, remove the
        // mins...
        if (vals.size() >= cap) {
            int evit = lists.get(min).iterator().next();
            lists.get(min).remove(evit);
            vals.remove(evit);
            counts.remove(evit);
        }

        // now, add the new value, update min = 1
        vals.put(key, value);
        counts.put(key, 1);
        min = 1;
        lists.get(1).add(key);
    }
}
