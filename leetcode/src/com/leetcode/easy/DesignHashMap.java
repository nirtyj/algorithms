package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Design a HashMap without using any built-in hash table libraries.
 *
 * To be specific, your design should include these functions:
 *
 * put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
 * get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 * remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
 *
 * Example:
 *
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);
 * hashMap.put(2, 2);
 * hashMap.get(1);            // returns 1
 * hashMap.get(3);            // returns -1 (not found)
 * hashMap.put(2, 1);          // update the existing value
 * hashMap.get(2);            // returns 1
 * hashMap.remove(2);          // remove the mapping for 2
 * hashMap.get(2);            // returns -1 (not found)
 *
 * Note:
 *
 * All keys and values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashMap library.
 */
public class DesignHashMap {
    int n = 1000;

    static class Entry {
        int key;
        int value;
        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    ArrayList<LinkedList<Entry>> hashMap;

    /** Initialize your data structure here. */
    public DesignHashMap() {
        hashMap = new ArrayList<LinkedList<Entry>>(n);
        for (int i=0;i<n;i++) {
            hashMap.add(i, new LinkedList<Entry>());
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = hash(key);
        LinkedList<Entry> list = hashMap.get(hash);
        Iterator<Entry> listItr = list.iterator();
        boolean updated = false;
        while(listItr.hasNext()) {
            Entry e = listItr.next();
            if (e.key == key) {
                e.value = value;
                updated = true;
                break;
            }
        }
        if (!updated) {
            list.addLast(new Entry(key, value));
        }

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int returnVal = -1;
        int hash = hash(key);

        LinkedList<Entry> list = hashMap.get(hash);
        Iterator<Entry> listItr = list.iterator();
        while(listItr.hasNext()) {
            Entry e = listItr.next();
            if (e.key == key) {
                returnVal = e.value;
                break;
            }
        }

        return returnVal;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = hash(key);
        LinkedList<Entry> list = hashMap.get(hash);
        Iterator<Entry> listItr = list.iterator();
        int i = 0;
        while(listItr.hasNext()) {
            Entry e = listItr.next();
            if (e.key == key) {
                break;
            }
            i++;
        }
        if (i <= list.size() -1)
            list.remove(i);
    }

    int hash(int key){
        return Integer.hashCode(key) % n;
    }
}
